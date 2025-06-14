package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verifyLoginTest() throws InterruptedException {
		logger.info("Started TC002_LoginTest");
		Thread.sleep(2000);
		try {

			// home page
			homepage = new HomePage(driver);
			homepage.clickMyAccountLink();
			logger.info("Clicked on MyAccounLink");

			loginpage = homepage.clickLoginLink();
			logger.info("Clicked on LoginLink");

			// loginpage=new LoginPage(driver);
			loginpage.setLoginEmailAdd(p.getProperty("E-MailAddress"));
			logger.info("Entered the  email");
			loginpage.setLoginPassword(p.getProperty("password"));
			logger.info("Entered the  password");
			myaccountpage = loginpage.clickLogin();
			logger.info("Click on login");

			logger.info("Validating login test");
			// myaccountpage=new MyAccountPage(driver);
			Assert.assertTrue(myaccountpage.getMyaccountTextMsg());
		} catch (Exception e) {
			Assert.fail();
			logger.error("Test failed");
		}
		logger.info("Completed TC002_LoginTest");

	}

}
