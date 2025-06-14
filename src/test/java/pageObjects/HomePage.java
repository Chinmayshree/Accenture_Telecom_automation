package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//i[@class='fa fa-user']")
	WebElement myAccountLnk;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registorLnk;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginLnk;

	public void clickMyAccountLink() {

		myAccountLnk.click();

	}

	public RegistorPage clickRegistorLink() {
		registorLnk.click();
		return new RegistorPage(driver);
	}

	public LoginPage clickLoginLink() {
		loginLnk.click();
		return new LoginPage(driver);
	}

}
