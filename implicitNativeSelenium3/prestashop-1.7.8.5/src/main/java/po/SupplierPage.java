package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupplierPage extends ElementManagementPage {
	
    @FindBy(id = "page-header-desc-configuration-add")
    protected WebElement addSupplier;
    
    @FindBy(xpath = "//*[@id=\"supplier_grid_table\"]/tbody/tr[1]/td[7]/div/div/a[2]")
    protected WebElement removeDropDown;
	
	public SupplierPage(WebDriver driver) {
		super(driver);
	}
	
	public AddSupplierPage clickAddSupplier() {
    	addSupplier.click();
    	return new AddSupplierPage(driver);
    }
	
	public SupplierPage removeSupplier() {
		removeDropDown.click();
		driver.findElement(By.xpath("//*[@id=\"supplier_grid_table\"]/tbody/tr[1]/td[7]/div/div/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"supplier-grid-confirm-modal\"]/div/div/div[3]/button[2]")).click();
		return new SupplierPage(driver);
	}

}
