package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends MainNavBar {
	
	@FindBy(id = "checkoutInformation")
	protected WebElement continueToShippingBtn;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ShippingPage continueToShipping() {
		continueToShippingBtn.click();
		return new ShippingPage(driver);
	}

}
