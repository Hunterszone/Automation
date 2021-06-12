package suite.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteUpload {

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
	public void uploadFile() {

		WebElement uploadMenu = driver.findElement(By.xpath("//a[text()=' Upload']"));
		uploadMenu.click();

		WebElement files = driver.findElement(By.id("files"));
		files.click();

		driver.get("http://hunterszone.hyperphp.com/WebSite/file_upload.html");

		WebElement chooseFile = driver.findElement(By.name("file"));
		chooseFile.sendKeys(System.getProperty("user.home") + "\\Desktop\\Dummy.txt");

		WebElement uploadButton = driver.findElement(By.xpath("//button[text()='Upload']"));
		uploadButton.click();

		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/account/file_upload.php";
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
	public void uploadAvatar() {

		WebElement uploadMenu = driver.findElement(By.xpath("//a[text()=' Upload']"));
		uploadMenu.click();

		WebElement files = driver.findElement(By.id("avatar"));
		files.click();

		driver.get("http://hunterszone.hyperphp.com/WebSite/avatar_upload.html");

		WebElement chooseFile = driver.findElement(By.name("file"));
		chooseFile.sendKeys(System.getProperty("user.home") + "\\Desktop\\Avatar.jpg");

		WebElement uploadButton = driver.findElement(By.xpath("//button[text()='Upload']"));
		uploadButton.click();

		String actualUrl = "http://hunterszone.hyperphp.com/WebSite/account/upload.php";
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
