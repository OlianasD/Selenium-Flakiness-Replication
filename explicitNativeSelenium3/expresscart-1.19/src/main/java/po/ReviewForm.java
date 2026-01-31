package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ReviewForm extends PageObject {
	
	@FindBy(id = "review-title")
	protected WebElement title;
	
	@FindBy(id = "addReview")
	protected WebElement addReviewBtn;

	protected Wait wait;

	public ReviewForm(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public ReviewForm setTitle(String titleStr) {
		wait.waitClickability(title);
		title.sendKeys(titleStr);
		return this;
	}
	
	public ReviewForm setDescr(String descr) {
		wait.waitClickability(By.id("review-description")).sendKeys(descr);
		return this;
	}
	
	public ReviewForm setRating(String rating) {
		wait.waitClickability(By.id("review-rating")).sendKeys(rating);
		return this;
	}
	
	public ProductPage addReview() {
		wait.waitClickability(addReviewBtn);
		addReviewBtn.click();
		return new ProductPage(driver);
	}
	
	public ReviewForm addReviewError() {
		wait.waitClickability(addReviewBtn);
		addReviewBtn.click();
		return new ReviewForm(driver);
	}
	
	public String getAlertMessage(String expected) {
		By locator = By.id("notify_message");
		wait.waitForTextToBe(locator, expected);
		return driver.findElement(locator).getText();
	}
	
	
	
	

}
