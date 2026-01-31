package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MainNavBar {
	
	@FindBy(className = "product-add-to-cart")
	protected WebElement addToCartBtn;
	
	@FindBy(id = "add-review")
	protected WebElement addReviewBtn;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ProductPage addToCart() {
		addToCartBtn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ProductPage(driver);
	}
	
	public ReviewForm addReview() {
		addReviewBtn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ReviewForm(driver);
		
	}
	
	public ProductPage recentReviews() {
		driver.findElement(By.linkText("Recent reviews")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public String getReviewRating() {
		return driver.findElement(By.xpath("//*[@id=\"collapseReviews\"]/li/p[2]")).getText();
	}
	
	public String getReviewTitle() {
		return driver.findElement(By.xpath("//*[@id=\"collapseReviews\"]/li/p[3]")).getText();
	}
	
	public String getReviewDescription() {
		return driver.findElement(By.xpath("//*[@id=\"collapseReviews\"]/li/p[4]")).getText();
	}
	
	
	
	

}
