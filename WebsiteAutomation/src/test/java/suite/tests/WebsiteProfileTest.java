package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WebsiteProfile;

public class WebsiteProfileTest {
	
	private WebDriver driver;
	private WebsiteProfile websiteProfile;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.byethost11.com/WebSite/forms/login_form.php");

		websiteProfile = new WebsiteProfile(driver);
		websiteProfile.loginToSite("admin", "Test123!");
		
		driver.get("http://hunterszone.byethost11.com/WebSite/auth/user_login.php");
	}
	
	@Test
	public void openProfileFromMenu() {
		
		websiteProfile.clickProfileButton();

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
	
	@Test
	public void openProfileFromAdminBanner() {
		
		websiteProfile.clickProfileBanner();

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
