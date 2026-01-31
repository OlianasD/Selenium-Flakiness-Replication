package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewForm extends PageObject {

	public ReviewForm(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ReviewForm setTitle(String title) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("review-title")).sendKeys(title);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public ReviewForm setDescr(String descr) {
		driver.findElement(By.id("review-description")).sendKeys(descr);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public ReviewForm setRating(String rating) {
		driver.findElement(By.id("review-rating")).sendKeys(rating);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public ProductPage addReview() {
		driver.findElement(By.id("addReview")).click();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ProductPage(driver);
	}
	
	public ReviewForm addReviewError() {
		driver.findElement(By.id("addReview")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ReviewForm(driver);
	}
	
	public String getAlertMessage() {
		//Please supply a review title
		return driver.findElement(By.id("notify_message")).getText();
	}
	
	
	
	

}
