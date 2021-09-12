package suite.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WebsiteLoginWithSms;

public class WebsiteLoginWithSmsTest {

	private WebDriver driver;
	private WebsiteLoginWithSms websiteLoginWithSms;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.byethost11.com/WebSite/sms/enterMobile.php");
	}

	@Test
	public void login() throws Exception {

		websiteLoginWithSms = new WebsiteLoginWithSms(driver);

		// Input mobile number - if not pre-selected
//		websiteLoginWithSms.setPhoneNumber("+359889619295");
		
		// Send token
		websiteLoginWithSms.clickSendCode();

		// Login
		websiteLoginWithSms.clickLogin();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}
}
