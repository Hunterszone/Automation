package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteContacts {
	
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
		
		WebElement contacts = driver.findElement(By.xpath("//a[text()=' Contacts']"));
		contacts.click();
	}
	
	@Test
	public void openFeedback() {
		
		WebElement feedback = driver.findElement(By.id("feedback"));
		feedback.click();
		
		driver.get("http://hunterszone.hyperphp.com/WebSite/forms/contact_form.php");
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("admin");
		
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("k.drenski91@aol.com");
		
		WebElement message = driver.findElement(By.name("message"));
		message.sendKeys("This is a test feedback!");
		
		WebElement send = driver.findElement(By.id("send"));
		send.click();
		
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
