package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends ElementManagementPage {
	
	@FindBy(id = "page-header-desc-configuration-add")
    protected WebElement addCategory;
	
	@FindBy(xpath = "//*[@id=\"tr_2_10_3\"]/td[7]/div/div/a[1]")
    protected WebElement editCategory;
	
	public CategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	public AddCategoryPage clickAddCategory() {
    	addCategory.click();
    	return new AddCategoryPage(driver);
    }
	
	public AddCategoryPage editCategory() {
		editCategory.click();
		return new AddCategoryPage(driver);
	}

}
