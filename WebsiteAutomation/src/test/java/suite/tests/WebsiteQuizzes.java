package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteQuizzes {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.hyperphp.com/WebSite/forms/login_form.php");
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.xpath("//button[text()='Login']"));

		username.sendKeys("admin");
		password.sendKeys("Troll123!");
		login.click();
		
		driver.get("http://hunterszone.hyperphp.com/WebSite/auth/user_login.php");
		
		WebElement webQuizzes = driver.findElement(By.id("quiz"));
		webQuizzes.click();
	}
	
	@Test
	public void openHTMLQuiz() {
		
		WebElement htmlQuizz = driver.findElement(By.xpath("//a[text()='HTML']"));
		htmlQuizz.click();
		
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
		
		WebElement cssQuizz = driver.findElement(By.xpath("//a[text()='CSS']"));
		cssQuizz.click();
		
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
		
		WebElement jsQuizz = driver.findElement(By.xpath("//a[text()='JavaScript']"));
		jsQuizz.click();
		
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
		
		WebElement phpQuizz = driver.findElement(By.xpath("//a[text()='PHP']"));
		phpQuizz.click();

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
