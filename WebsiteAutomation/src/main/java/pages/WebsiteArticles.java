package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebsiteArticles {

	WebDriver driver;

	@FindBy(xpath = "//button[text()=' Articles']")
	WebElement articles;

	@FindBy(xpath = "//button[text()='HTML']")
	WebElement htmlArticle;
	
	@FindBy(xpath = "//button[text()='CSS']")
	WebElement cssArticle;
	
	@FindBy(xpath = "//button[text()='JS']")
	WebElement jsArticle;
	
	@FindBy(xpath = "//button[text()='PHP']")
	WebElement phpArticle;

	public WebsiteArticles(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void clickArticles() {
		articles.click();
	}

	public void clickHtmlArticle() {
		htmlArticle.click();
	}
	
	public void clickCssArticle() {
		cssArticle.click();
	}

	public void clickJsArticle() {
		jsArticle.click();
	}
	
	public void clickPhpArticle() {
		phpArticle.click();
	}
}