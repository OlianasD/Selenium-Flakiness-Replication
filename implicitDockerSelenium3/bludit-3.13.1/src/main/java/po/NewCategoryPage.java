package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCategoryPage extends AdminSidebar {
	
	@FindBy(id = "jsname")
	protected WebElement name;
	
	@FindBy(id = "jsdescription")
	protected WebElement description;
	
	@FindBy(name = "save")
	protected WebElement saveBtn;
	
	public NewCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	public NewCategoryPage setName(String name) {
		this.name.sendKeys(name);
		return this;
	}
	
	public NewCategoryPage setDescr(String descr) {
		description.sendKeys(descr);
		return this;
	}
	
	public CategoriesPage save() {
		saveBtn.click();
		return new CategoriesPage(driver);
	}

}
