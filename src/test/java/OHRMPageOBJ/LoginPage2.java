package OHRMPageOBJ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 extends BaseClass {

//consructor
	public LoginPage2(WebDriver driver) {
		super(driver);
	}

	// locator

	// @FindBy(xpath="//input[@placeholder='Username']")

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	WebElement userName1;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passWD;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginBtn;

//Actions Methods

	public void setUserName(String user) {
		userName1.sendKeys(user);
	}

	public void setPassWd(String pass) {
		passWD.sendKeys(pass);

	}

	public void getLoginbtn() {
		loginBtn.click();
	}
}
