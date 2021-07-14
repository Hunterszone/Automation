package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebsiteContacts {
	
	WebDriver driver;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement login;
	
	@FindBy(xpath = "//a[text()=' Contacts']")
	WebElement contacts;
	
	@FindBy(id = "feedback")
	WebElement feedback;
	
	@FindBy(name = "name")
	WebElement name;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "message")
	WebElement message;
	
	@FindBy(id = "send")
	WebElement send;
	
	public WebsiteContacts(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void setUsername(String usr) {
		username.sendKeys(usr);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void loginToSite(String usr, String pwd) {
		this.setUsername(usr);
		this.setPassword(pwd);
		clickLogin();
	}
	
	public void clickContacts() {
		contacts.click();
	}
	
	public void clickFeedback() {
		feedback.click();
	}

	public void setName(String authorName) {
		name.sendKeys(authorName);
	}

	public void setEmail(String authorEmail) {
		email.sendKeys(authorEmail);
	}

	public void setMessage(String msg) {
		message.sendKeys(msg);
	}
	
	public void clickSend() {
		send.click();
	}
	
	public void sendFeedback(String authorName, String authorEmail, String msg) {
		this.setName(authorName);
		this.setEmail(authorEmail);
		this.setMessage(msg);
		this.clickSend();
	}
}
