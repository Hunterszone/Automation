package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebsiteProfile {

	WebDriver driver;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement login;
	
	@FindBy(id = "profile")
	WebElement profile;
	
	@FindBy(xpath = "//p[text()='admin']")
	WebElement profileBanner;

	public WebsiteProfile(WebDriver driver) {

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
	
	public void clickProfileButton() {
		profile.click();
	}
	
	public void clickProfileBanner() {
		profileBanner.click();
	}
}