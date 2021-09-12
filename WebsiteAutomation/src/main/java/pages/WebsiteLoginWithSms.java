package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebsiteLoginWithSms {

	WebDriver driver;

	@FindBy(name = "phoneNum")
	WebElement inputPhoneNumber;

	@FindBy(xpath = "//button[text()='Send code']")
	WebElement sendCode;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement login;
	
	public WebsiteLoginWithSms(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void setPhoneNumber(String phoneNumber) {
		inputPhoneNumber.sendKeys(phoneNumber);
	}
	
	public void clickSendCode() {
		sendCode.click();
	}
	
	public void clickLogin() {
		login.click();
	}
}