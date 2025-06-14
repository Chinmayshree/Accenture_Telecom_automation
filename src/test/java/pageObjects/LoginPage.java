package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement loginEmailTxt;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement loginPasswordTxt;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	public void setLoginEmailAdd(String loginemail) {
		loginEmailTxt.sendKeys(loginemail);
	}

	public void setLoginPassword(String pwd) {
		loginPasswordTxt.sendKeys(pwd);
	}

	public MyAccountPage clickLogin() {
		loginBtn.click();
		return new MyAccountPage(driver);
	}

}
