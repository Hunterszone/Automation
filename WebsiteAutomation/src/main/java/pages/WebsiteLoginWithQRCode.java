package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebsiteLoginWithQRCode {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Enter verification code']")
	WebElement enterCodeLink;
	
	@FindBy(xpath = "//button[text()='Send code']")
	WebElement sendCode;
	
	@FindBy(name = "code")
	WebElement codeField;
	
	@FindBy(id = "qrImg")
	WebElement qrImg;

	public WebsiteLoginWithQRCode(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void clickCodeLink() {
		enterCodeLink.click();
	}
	
	public void clickSendCode() {
		sendCode.click();
	}
	
	public void setCodeIntoField(String code) {
		codeField.sendKeys(code);
	}
	
	public WebElement getQrImg() {
		return qrImg;
	}
}