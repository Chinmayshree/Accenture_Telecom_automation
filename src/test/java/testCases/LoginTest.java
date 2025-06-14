//package testCases;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import OHRMPageOBJ.LoginPage1;
//import OHRMPageOBJ.LoginPage2;
//
//public class LoginTest {
//	WebDriver driver;
//
//	@BeforeClass
//	void setUp() {
//
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	}
//
//	@Test
//	void testLogin() {
////	 LoginPage1 login=new LoginPage1(driver);
////	 login.setUsrName("Admin");
////	 login.setPassWd("admin123");
////	 login.getLoginBtn();
////	 Assert.assertEquals(driver.getTitle(), "OrangeHRM");
////		 
//		LoginPage2 login2 = new LoginPage2(driver);
//		login2.setUserName("Admin");
//		login2.setPassWd("admin123");
//		login2.getLoginbtn();
//		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
//
//	}
//
//	@AfterClass
//	void tearDown() {
//
//		driver.quit();
//
//	}
//
//}
