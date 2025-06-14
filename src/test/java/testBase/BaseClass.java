package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountSuccessPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.RegistorPage;
import utilities.ExcelUtility;

public class BaseClass {

	public Logger logger;
	public static WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public MyAccountPage myaccountpage;
	public RegistorPage registerpage;
	public AccountSuccessPage accountsuccesspage;
	public RandomStringUtils random;
	public Properties p;
	public ExcelUtility utility;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "browser", "os" })
	public void setup(String br, String os) throws IOException {

		// Creating logger object
		logger = LogManager.getLogger(this.getClass());

		// Lauching browser
		switch (br.toLowerCase()) {
		case "chrome" -> {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("ChromeBrowser Launched");
			break;
		}
		case "firefox" -> {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("FireFoxBrowser Launched");
			break;
		}
		case "edge" -> {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("EdgeBrowser Launched");
			break;
		}
		default -> {
			System.out.println("Plz Enter the valid browser name");
			return;
		}

		}

		// loading and Creating config properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		// maximize the browser
		driver.manage().window().maximize();
		logger.info("maximizing window");

		// apply implicitwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURl"));
		logger.info("url launched");
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		// driver.close();
		driver.quit();
	}

	// Creating Random String
	public static String randomString() {

		String randomAlphabetic = RandomStringUtils.randomAlphabetic(6);
		return randomAlphabetic;
	}

	// Creating Random Number
	public static String randomNumber() {

		String randomNumeric = RandomStringUtils.randomNumeric(10);
		return randomNumeric;
	}

	// Creating Random AlphaNumeric
	public static String randomeAlphaNumeric() {

		String randomalphaNumber = RandomStringUtils.randomAlphanumeric(10);
		return randomalphaNumber;
	}

	public String password = randomeAlphaNumeric();

	// Creating Ramdom Email
	public static String randomeEmail() {

		String randomString = RandomStringUtils.randomAlphabetic(6);
		return randomString + "@gamil.com";
	}

	// Capturing ScreenShots
	public String CaptureScreenshot(String testName) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddmmss").format(new Date());

		TakesScreenshot taksScreenShot = (TakesScreenshot) driver;
		File sourceFile = taksScreenShot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenShots\\" + testName + "-" + timeStamp
				+ ".png";
		File targetFile = new File(targetFilePath);

		// coping the source file to target file
		FileUtils.copyFile(sourceFile, targetFile);

		return targetFilePath;
	}
}
