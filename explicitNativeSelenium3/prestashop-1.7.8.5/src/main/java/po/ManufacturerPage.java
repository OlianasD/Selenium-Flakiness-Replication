package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManufacturerPage extends ElementManagementPage {
	
	@FindBy(id = "page-header-desc-configuration-add_manufacturer")
    protected WebElement addManufacturer;
	
    @FindBy(xpath =  "//*[@id=\"manufacturer_grid_table\"]/tbody/tr/td[8]/div/div/a[2]")
    protected WebElement editDropDown;
    
    @FindBy(id = "subtab-AdminSuppliers")
    protected WebElement supplierTab;
    
	
	public ManufacturerPage(WebDriver driver) {
		super(driver);
	}
	
	public AddManufacturerPage clickAddManufacturer() {
    	addManufacturer.click();
    	return new AddManufacturerPage(driver);
    }
	
	public AddManufacturerPage editManufacturer() {
		editDropDown.click();
		driver.findElement(By.xpath("//*[@id=\"manufacturer_grid_table\"]/tbody/tr/td[8]/div/div/div/a[1]")).click();
		return new AddManufacturerPage(driver);
	}
	
	public SupplierPage suppliersTab() {
		supplierTab.click();
		return new SupplierPage(driver);
	}
	

}
