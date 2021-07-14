package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WebsiteContacts;

public class WebsiteContactsTest {
	
	private WebDriver driver;
	private WebsiteContacts websiteContacts;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.hyperphp.com/WebSite/forms/login_form.php");
	}
	
	@Test
	public void sendFeedback() {
		
		websiteContacts = new WebsiteContacts(driver);
		websiteContacts.loginToSite("admin", "Troll123!");
		
		driver.get("http://hunterszone.hyperphp.com/WebSite/auth/user_login.php");
		
		websiteContacts.clickContacts();
		websiteContacts.clickFeedback();
		
		driver.get("http://hunterszone.hyperphp.com/WebSite/forms/contact_form.php");
		
		websiteContacts.sendFeedback("admin", "k.drenski91@aol.com", "This is a test feedback!");
		
		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/forms/contact_form.php";
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