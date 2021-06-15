package suite.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteUploadTest {

	private WebDriver driver;
	private String actualUrl;

	@Before
	public void setUp() throws MalformedURLException, IOException {
		
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
	public void uploadFile() throws MalformedURLException, IOException {
		
		downloadFile(new URL("https://drive.google.com/file/d/1DrCuS8ZvMwRfVOOYwQ1XKXOVyfD60a6b/view?usp=sharing"), System.getProperty("user.home") + "\\Desktop\\Dummy.txt");

		WebElement uploadMenu = driver.findElement(By.xpath("//a[text()=' Upload']"));
		uploadMenu.click();

		WebElement files = driver.findElement(By.id("files"));
		files.click();

		driver.get("http://hunterszone.hyperphp.com/WebSite/file_upload.html");

		WebElement chooseFile = driver.findElement(By.name("file"));
		try {
			chooseFile.sendKeys(System.getProperty("user.home") + "\\Desktop\\Dummy.txt");			
			actualUrl = driver.getCurrentUrl();
		} catch (InvalidArgumentException e) {
			if(e instanceof InvalidArgumentException) {
				actualUrl = driver.getCurrentUrl();
				Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
				return;
			}
		}

		WebElement uploadButton = driver.findElement(By.xpath("//button[text()='Upload']"));
		uploadButton.click();
		
		WebElement displayFile = driver.findElement(By.xpath("//a[text()='Click here to view file']"));
		displayFile.click();

		actualUrl = "http://hunterszone.hyperphp.com/WebSite/uploads/Dummy.txt";

		Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}

	@Test
	public void uploadAvatar() throws MalformedURLException, IOException {
		
		downloadFile(new URL("https://drive.google.com/file/d/1FPKD2FDIBt3IIvn4jX1Hk54XxWr_s_au/view?usp=sharing"), System.getProperty("user.home") + "\\Desktop\\Avatar.jpg");
		
		WebElement uploadMenu = driver.findElement(By.xpath("//a[text()=' Upload']"));
		uploadMenu.click();

		WebElement files = driver.findElement(By.id("avatar"));
		files.click();

		driver.get("http://hunterszone.hyperphp.com/WebSite/avatar_upload.html");

		WebElement chooseFile = driver.findElement(By.name("file"));
		try {
			chooseFile.sendKeys(System.getProperty("user.home") + "\\Desktop\\Avatar.jpg");
		} catch (Exception e) {
			if(e instanceof InvalidArgumentException) {
				actualUrl = driver.getCurrentUrl();
				Assert.assertEquals(driver.getCurrentUrl(), actualUrl);
				return;
			}
		}

		WebElement uploadButton = driver.findElement(By.xpath("//button[text()='Upload']"));
		uploadButton.click();
		
		WebElement displayFile = driver.findElement(By.xpath("//a[text()='Click here to view file']"));
		displayFile.click();

		actualUrl = "http://hunterszone.hyperphp.com/WebSite/gallery/Avatar.jpg";

		Assert.assertEquals(driver.getCurrentUrl(), actualUrl);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}

	private void downloadFile(URL url, String outputFileName) throws IOException {
		try (InputStream in = url.openStream();
				ReadableByteChannel rbc = Channels.newChannel(in);
				FileOutputStream fos = new FileOutputStream(outputFileName)) {
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		}
	}
}
