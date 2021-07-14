package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebsiteQuizzes {

	WebDriver driver;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "quiz")
	WebElement quizz;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement login;
	
	@FindBy(xpath = "//a[text()='HTML']")
	WebElement htmlQuizz;
	
	@FindBy(xpath = "//a[text()='CSS']")
	WebElement cssQuizz;
	
	@FindBy(xpath = "//a[text()='JavaScript']")
	WebElement jsQuizz;
	
	@FindBy(xpath = "//a[text()='PHP']")
	WebElement phpQuizz;
	
	public WebsiteQuizzes(WebDriver driver) {

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
	
	public void clickQuizzButton() {
		quizz.click();
	}
	
	public void clickHtmlQuizz() {
		htmlQuizz.click();
	}
	
	public void clickCssQuizz() {
		cssQuizz.click();
	}
	
	public void clickJsQuizz() {
		jsQuizz.click();
	}

	public void clickPhpQuizz() {
		phpQuizz.click();
	}
}