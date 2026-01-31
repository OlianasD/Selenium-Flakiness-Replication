package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends MainNavBar {
	
	@FindBy(id = "discountCode")
	protected WebElement discountCode;
	
	@FindBy(id = "addDiscountCode")
	protected WebElement addDiscountCodeBtn;

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public PaymentPage setDiscountCode(String code) {
		discountCode.sendKeys(code);
		return this;
	}
	
	public PaymentPage addDiscountCode(long millis) {
		addDiscountCodeBtn.click();
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public boolean containsDiscountText(String discountText) {
		return driver.findElement(By.tagName("body")).getText().contains(discountText);
	}
	
	public String getDangerAlertText() {
		return driver.findElement(By.className("alert-danger")).getText();
	}
	
	

}
