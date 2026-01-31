package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends ElementManagementPage {
	
	@FindBy(id = "page-header-desc-configuration-add")
	protected WebElement addAddress;
	
	@FindBy(xpath = "//*[@id=\"address_grid_table\"]/tbody/tr[1]/td[9]/div/div/a[1]")
    protected WebElement edit;

	public AddressesPage(WebDriver driver) {
		super(driver);
	}
	
	public AddAddressPage addAddress() {
		addAddress.click();
		return new AddAddressPage(driver);
	}
	
	public AddAddressPage editAddress() {
		edit.click();
		return new AddAddressPage(driver);
	}
	

	
	

}
