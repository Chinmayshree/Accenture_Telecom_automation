package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

//data is valid---login success------test is passed  ----logout
//data is valid---login failed----test is failed

//data is invalid ----login success----- test is failed  ---- logout
//dada is invalid ----login failed ----test is passed

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "DataDriven" })
	public void verify_LoginDDT(String email, String pwd, String exp) {
		try {
			logger.info("Started TC003_LoginDDTTest");
			// homePage
			homepage = new HomePage(driver);
			homepage.clickMyAccountLink();
			loginpage = homepage.clickLoginLink();

			// loginaPage
			// loginpage=new LoginPage(driver);
			loginpage.setLoginEmailAdd(email);
			loginpage.setLoginPassword(pwd);
			myaccountpage = loginpage.clickLogin();

			// myAccountPage
			// myaccountpage=new MyAccountPage(driver);
			boolean myAccountTxt = myaccountpage.getMyaccountTextMsg();
			System.out.println(myAccountTxt);
			myaccountpage.clickLogoutLink();

			if (exp.equalsIgnoreCase("valid")) {

				if (myAccountTxt == true) {
					myaccountpage.clickLogoutLink();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}

			if (exp.equalsIgnoreCase("invalid")) {

				if (myAccountTxt == true) {
					myaccountpage.clickLogoutLink();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {

			logger.error("exception");
			Assert.fail();

		}

		logger.info("Finished TC003_LoginDDT Test");
	}

}
