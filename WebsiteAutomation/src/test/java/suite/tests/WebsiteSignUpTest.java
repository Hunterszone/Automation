package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebsiteSignUpTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hunterszone.byethost11.com/WebSite/index.php");
	}
	
	@Test
	public void register() {
		
		WebElement signUp = driver.findElement(By.xpath("//button[text()=' Sign up']"));
		signUp.click();
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("kossio");
						
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("k.drenski91@aol.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Test123!");
		
		WebElement pwd2 = driver.findElement(By.name("pwd2"));
		pwd2.sendKeys("Test123!");
		
		Select month = new Select(driver.findElement(By.name("month")));
		month.selectByVisibleText("November");
		
		WebElement terms = driver.findElement(By.id("field_terms"));
		terms.click();
		
		WebElement register = driver.findElement(By.id("registration"));
		register.click();
		
		String actualUrl = "http://hunterszone.byethost11.com/WebSite/connectivity/code_exec.php";
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
