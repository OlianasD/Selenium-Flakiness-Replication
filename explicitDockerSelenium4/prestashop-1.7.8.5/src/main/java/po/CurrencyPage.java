package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyPage extends ElementManagementPage {
	
	@FindBy(id = "page-header-desc-configuration-add")
    protected WebElement addCurrency;
	
	public CurrencyPage(WebDriver driver) {
		super(driver);
	}
	
	public AddCurrencyPage clickAddCurrency() {
		addCurrency.click();
		return new AddCurrencyPage(driver);
	}

}
