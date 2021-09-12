package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WebsiteLoginWithCredentials;

public class WebsiteLoginWithCredentialsTest {
	
	private WebDriver driver;
	private WebsiteLoginWithCredentials websiteLoginWithCredentials;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.byethost11.com/WebSite/forms/login_form.php");
	}
	
	@Test
	public void login() {
		
		websiteLoginWithCredentials = new WebsiteLoginWithCredentials(driver);
		websiteLoginWithCredentials.loginToSite("admin", "Test123!");
		
		String actualUrl = "http://hunterszone.byethost11.com/WebSite/auth/user_login.php";
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
