package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewsPage extends AdminSidebar {
	
	@FindBy(xpath = "/html/body/div[2]/div/main/div[3]/ul/li[2]/div/div[4]/a")
	protected WebElement firstReviewDelBtn;

	public ReviewsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ReviewsPage deleteFirstReview() {
		firstReviewDelBtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public boolean containsReview(String review) {
		return driver.findElement(By.xpath("/html/body/div[2]/div/main/div[3]/ul/li[2]/div/div[1]/div")).getText().contains(review);
	}

}
