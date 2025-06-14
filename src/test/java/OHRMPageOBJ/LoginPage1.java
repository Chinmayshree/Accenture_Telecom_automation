package OHRMPageOBJ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 {

	WebDriver driver;
	// constructor

	public LoginPage1(WebDriver driver) {
		this.driver = driver;

	}

	// Locators
	By userName = By.xpath("//input[@placeholder='Username']");
	By passWd = By.xpath("//input[@placeholder='Password']");
	By loginBtn = By.xpath("//button[normalize-space()='Login']");

	// Action Methods

	public void setUsrName(String user) {

		driver.findElement(userName).sendKeys(user);

	}

	public void setPassWd(String passwd) {
		driver.findElement(passWd).sendKeys(passwd);
	}

	public void getLoginBtn() {
		driver.findElement(loginBtn).click();

	}

}
