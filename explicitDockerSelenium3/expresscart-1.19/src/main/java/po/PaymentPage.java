package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class PaymentPage extends MainNavBar {
	
	@FindBy(id = "discountCode")
	protected WebElement discountCode;
	
	@FindBy(id = "addDiscountCode")
	protected WebElement addDiscountCodeBtn;
	
	@FindBy(className = "alert-danger")
	protected WebElement alert;

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public PaymentPage setDiscountCode(String code) {
		wait.waitClickability(discountCode);
		discountCode.sendKeys(code);
		return this;
	}
	
	public PaymentPage addDiscountCode() {
		wait.waitClickability(addDiscountCodeBtn);
		addDiscountCodeBtn.click();		
		return this;
	}
	
	public boolean containsDiscountText(String discountText) {
		By locator = By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]");
		wait.waitForTextToBe(locator, discountText);
		return driver.findElement(locator).getText().contains(discountText);
	}
	
	public String getDangerAlertText() {
		wait.waitVisibility(alert);
		return alert.getText();
	}
	
	

}
