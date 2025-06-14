package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage extends BasePage {

	public AccountSuccessPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement registerConformationMsg;

	@FindBy(linkText = "Continue")
	WebElement continueBtn;

	public String getRegisterConformationMsg() {
		try {
			return registerConformationMsg.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public MyAccountPage clkContinueBtn() {

		continueBtn.click();
		return new MyAccountPage(driver);
	}

}
