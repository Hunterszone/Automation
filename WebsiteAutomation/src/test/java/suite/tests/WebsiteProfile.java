package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteProfile {
	
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
	}
	
	@Test
	public void openProfileFromMenu() {
		
		WebElement profile = driver.findElement(By.id("profile"));
		profile.click();

		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/auth/user_login.php";
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
		
		WebElement profile = driver.findElement(By.xpath("//p[text()='admin']"));
		profile.click();

		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/auth/user_login.php";
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
