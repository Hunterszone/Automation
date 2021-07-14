package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WebsiteQuizzes;

public class WebsiteQuizzesTest {
	
	private WebDriver driver;
	private WebsiteQuizzes websiteQuizzes;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.hyperphp.com/WebSite/forms/login_form.php");
		
		websiteQuizzes = new WebsiteQuizzes(driver);
		websiteQuizzes.loginToSite("admin", "Troll123!");
		
		driver.get("http://hunterszone.hyperphp.com/WebSite/auth/user_login.php");
		
		websiteQuizzes.clickQuizzButton();
	}
	
	@Test
	public void openHTMLQuiz() {
		
		websiteQuizzes.clickHtmlQuizz();
		
		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/quizes/quizes.php";
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
	public void openCSSQuiz() {
		
		websiteQuizzes.clickCssQuizz();
		
		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/quizes/quizes.php";
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
	public void openJSQuiz() {
		
		websiteQuizzes.clickJsQuizz();
		
		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/quizes/quizes.php";
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
	public void openPHPQuiz() {
		
		websiteQuizzes.clickPhpQuizz();

		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/quizes/quizes.php";
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
