package suite.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WebsiteArticles;

public class WebsiteArticlesTest {
	
	private WebDriver driver;
	private WebsiteArticles websiteArticles;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.byethost11.com/WebSite/index.php");
	}
	
	@Test
	public void openHtml() {
		
		websiteArticles = new WebsiteArticles(driver);
		websiteArticles.clickArticles();
		websiteArticles.clickHtmlArticle();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualUrl = "http://hunterszone.byethost11.com/WebSite/index.php?i=1";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}
	
	@Test
	public void openCss() {

		websiteArticles = new WebsiteArticles(driver);
		websiteArticles.clickArticles();
		websiteArticles.clickCssArticle();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualUrl = "http://hunterszone.byethost11.com/WebSite/index.php?i=1";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}
	
	@Test
	public void openJs() {
		
		websiteArticles = new WebsiteArticles(driver);
		websiteArticles.clickArticles();
		websiteArticles.clickJsArticle();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualUrl = "http://hunterszone.byethost11.com/WebSite/index.php?i=1";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}
	
	@Test
	public void openPhp() {
		
		websiteArticles = new WebsiteArticles(driver);
		websiteArticles.clickArticles();
		websiteArticles.clickPhpArticle();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualUrl = "http://hunterszone.byethost11.com/WebSite/index.php?i=1";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}
	
	@After
	public void tearDown() {
		driver = null;
	}
}
