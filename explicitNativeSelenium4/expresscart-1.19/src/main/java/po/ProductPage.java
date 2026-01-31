package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ProductPage extends MainNavBar {
	
	@FindBy(className = "product-add-to-cart")
	protected WebElement addToCartBtn;
	
	@FindBy(id = "add-review")
	protected WebElement addReviewBtn;
	
	@FindBy(linkText = "Recent reviews")
	protected WebElement recentReviews;
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductPage addToCart() {
		wait.waitClickability(addToCartBtn);
		addToCartBtn.click();
		return new ProductPage(driver);
	}
	
	public ReviewForm addReview() {
		wait.waitClickability(addReviewBtn);
		addReviewBtn.click();
		return new ReviewForm(driver);
		
	}
	
	public ProductPage recentReviews() {
		wait.waitClickability(recentReviews);
		recentReviews.click();
		return this;
	}
	
	public String getReviewRating(String expected) {
		By locator = By.xpath("//*[@id=\"collapseReviews\"]/li/p[2]");
		wait.waitForTextToBe(locator, expected);
		return driver.findElement(locator).getText();
	}
	
	public String getReviewTitle(String expected) {
		By locator = By.xpath("//*[@id=\"collapseReviews\"]/li/p[3]");
		wait.waitForTextToBe(locator, expected);
		return driver.findElement(locator).getText();
	}
	
	public String getReviewDescription(String expected) {
		By locator = By.xpath("//*[@id=\"collapseReviews\"]/li/p[4]");
		wait.waitForTextToBe(locator, expected);
		return driver.findElement(locator).getText();
	}
	
	
	
	

}
