package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WebsiteLogout;

public class WebsiteLogoutTest {
	
	private WebDriver driver;
	private WebsiteLogout websiteLogout;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.hyperphp.com/WebSite/forms/login_form.php");
	}
	
	@Test
	public void logout() {
		
		websiteLogout = new WebsiteLogout(driver);
		websiteLogout.loginToSite("admin", "Troll123!");
		
		driver.get("http://hunterszone.hyperphp.com/WebSite/auth/user_login.php");
		
		websiteLogout.clickLogout();

		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/index.php";
		String expectedUrl = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actualUrl);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}
}
