package suite.tests;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.jboss.aerogear.security.otp.Totp;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

public class WebsiteLoginWithQRCode {

	@Test
	public void login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://hunterszone.hyperphp.com/WebSite/qr/generateQR.php");

		String src = driver.findElement(By.id("qrImg")).getAttribute("src");
		System.out.println("image url is: " + src);

		// Get QR img from URL
		URL urlOfImage = new URL(src);
		BufferedImage bufferedImage = ImageIO.read(urlOfImage);

		// Convert it to bitmap
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		// Read & scan the QR code
		QRCodeReader reader = new QRCodeReader();
		Hashtable<DecodeHintType, Object> decodeHints = new Hashtable<DecodeHintType, Object>();
		decodeHints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
		Result result = reader.decode(bitmap, decodeHints);
		String textPresentInImage = result.getText();

		// Click link to enter token
		WebElement enterCodeLink = driver.findElement(By.xpath("//a[text()='Enter verification code']"));
		enterCodeLink.click();

		driver.get("http://hunterszone.hyperphp.com/WebSite/qr/verifyQR.html");
		WebElement codeField = driver.findElement(By.name("code"));
		
		// Generate token and enter it
		String otpKeyStr = "6jm7n6xwitpjooh7ihewyyzeux7aqmw2"; // <- this 2FA secret key.
		Totp totp = new Totp(otpKeyStr);
		String twoFactorCode = totp.now(); // <- got 2FA code at this time!
		System.out.println("OTP: " + twoFactorCode);
		codeField.sendKeys(twoFactorCode);

		// Send token
		WebElement sendCode = driver.findElement(By.xpath("//button[text()='Send code']"));
		sendCode.click();

		Assert.assertEquals(textPresentInImage,
				"otpauth://totp/@me4gaming.com?secret=7WAO342QFANY6IKBF7L7SWEUU79WL3VMT920VB5NQMW");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();
	}
}
