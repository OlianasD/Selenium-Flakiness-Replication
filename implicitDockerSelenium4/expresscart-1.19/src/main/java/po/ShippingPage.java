package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends MainNavBar {
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div/div/div[1]/a[2]")
	protected WebElement goToPaymentBtn;

	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public PaymentPage goToPayment() {
		goToPaymentBtn.click();
		return new PaymentPage(driver);
	}

}
