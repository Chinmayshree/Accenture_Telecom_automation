package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistorPage extends BasePage {
	public RegistorPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPrivacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String number) {
		txtTelephone.sendKeys(number);
	}

	public void setPssword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setConfirmPssword(String cnfPassword) {
		txtConfirmPassword.sendKeys(cnfPassword);
	}

	public void checkMarkPrivacyPolicyChkBox() {
		chkPrivacyPolicy.click();

	}

	public AccountSuccessPage clickContinueBtn() {
		btnContinue.click();
		return new AccountSuccessPage(driver);

	}
}
