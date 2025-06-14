package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtendReportManager implements ITestListener {

	ExtentSparkReporter sparkReporter; // UI of report eg.dark theme,wer we should display information ,location
	// location of information,it always deal with look feel of
	// report,allignment,colour etc

	ExtentReports extent; // populating some common information in report eg.tester name,browser
							// name,operating
	// system,project name,module name,test environment etc

	ExtentTest test; // creating test entries in the report updating status in report eg.updating
						// status like passed,failed,skipped,attaching screenshot
	// on failures

	String repName;

	public void onStart(ITestContext testContext) {

		/*
		 * SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); Date dt=new
		 * Date(); String DatetimeStamp = df.format(dt);
		 */

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";

		// Creating UI of Report
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

		sparkReporter.config().setDocumentTitle("opencart Automation Report");
		sparkReporter.config().setReportName("opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		// populating common information in report
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter); // attaching extendReport to sparkReporter

		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub-Module", "Customer");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Nivrutti");
		// extent.setSystemInfo("Operting System","windows-7");
		// extent.setSystemInfo("Browser Name","Chrome");

		// TestName or user
		extent.setSystemInfo("User Name", System.getProperty("user.name"));

		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operting System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser Name", browser);

		List<String> includedGroups = testContext.getCurrentXmlTest().getExcludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}

	}

	public void onTestSuccess(ITestResult result) {

		// to display class name in report
		ExtentTest test = extent.createTest(result.getTestClass().getName());
		// to display groups in report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + " got PASSED ");

	}

	public void onTestFailure(ITestResult result) {

		// to display class name in report
		ExtentTest test = extent.createTest(result.getTestClass().getName());
		// to display groups in report
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " got FAILED ");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseClass().CaptureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " got SKIPPED ");
		test.log(Status.INFO, result.getThrowable().getMessage());

	}

	public void onFinish(ITestContext context) {

		extent.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathOfExtentReport);

		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
