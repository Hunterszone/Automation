package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteArticles {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.hyperphp.com/WebSite/index.php");
	}
	
	@Test
	public void openHtml() {
		WebElement articles = driver.findElement(By.xpath("//button[text()=' Articles']"));
		articles.click();
		WebElement htmlArticle = driver.findElement(By.xpath("//button[text()='HTML']"));
		htmlArticle.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/index.php?i=1";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}
	
	@Test
	public void openCss() {
		WebElement articles = driver.findElement(By.xpath("//button[text()=' Articles']"));
		articles.click();
		WebElement cssArticle = driver.findElement(By.xpath("//button[text()='CSS']"));
		cssArticle.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/index.php?i=1";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}
	
	@Test
	public void openJs() {
		WebElement articles = driver.findElement(By.xpath("//button[text()=' Articles']"));
		articles.click();
		WebElement jsArticle = driver.findElement(By.xpath("//button[text()='JS']"));
		jsArticle.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/index.php?i=1";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}
	
	@Test
	public void openPhp() {
		WebElement articles = driver.findElement(By.xpath("//button[text()=' Articles']"));
		articles.click();
		WebElement phpArticle = driver.findElement(By.xpath("//button[text()='PHP']"));
		phpArticle.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/index.php?i=1";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		driver.quit();
	}
}
