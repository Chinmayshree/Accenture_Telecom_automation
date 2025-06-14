package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistorTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	void verifyRegistorAccountTest() {

		try {
			logger.info("Started TC001_AccountRegistorTest");

			homepage = new HomePage(driver);
			homepage.clickMyAccountLink();
			logger.info("Clicked on MyAccount Link");

			registerpage = homepage.clickRegistorLink();
			logger.info("Clicked on registor Link");

			// registerpage=new RegistorPage(driver);
			// registerpage=factory.getRegistorPageObject(driver);

			logger.info("Providing Customer Details");

			registerpage.setFirstName(randomString().toUpperCase());
			logger.info("Enter FirstName");
			registerpage.setLastName(randomString().toUpperCase());
			logger.info("Enter LastName");
			registerpage.setEmail(randomeEmail());
			logger.info("Enter Email");
			registerpage.setTelephone(randomNumber());
			logger.info("Enter PhoneNumber");
			registerpage.setPssword(password);
			logger.info("Enter Password");
			registerpage.setConfirmPssword(password);
			logger.info("Enter Re-enter Password");
			registerpage.checkMarkPrivacyPolicyChkBox();
			logger.info("checkmark PrivacyPolicy");
			accountsuccesspage = registerpage.clickContinueBtn();
			logger.info("click on continue");

			logger.info("Validating Conformation Message");
			String registerConfirmMsg = accountsuccesspage.getRegisterConformationMsg();
			if (registerConfirmMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.info("Test failed....");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			logger.info("Exception occurced");
			Assert.fail();

		}

		logger.info("Completed TC001_AccountRegisterTest");
	}

}
