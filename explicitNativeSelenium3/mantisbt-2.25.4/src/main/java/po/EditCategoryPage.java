package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCategoryPage extends BaseNavBar {
	
	@FindBy(id = "proj-category-name")
	protected WebElement categoryName;
	
	@FindBy(xpath = "//*[@id=\"manage-proj-category-update-form\"]/div/div[3]/input")
	protected WebElement updateCategoryBtn;
	
	public EditCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	public EditCategoryPage setCategoryName(String name) {
		wait.waitClickability(categoryName);
		categoryName.clear();
		categoryName.sendKeys(name);
		return this;
	}
	
	public EditProjectPage updateCategory() {
		wait.waitClickability(updateCategoryBtn);
		updateCategoryBtn.click();
		return new EditProjectPage(driver);
	}
	
	

}
