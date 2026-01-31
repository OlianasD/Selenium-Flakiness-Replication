package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends AdminSidebar {
	
	@FindBy(linkText = "Add a new category")
	protected WebElement addCategory;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/table/tbody/tr[1]/td[1]/a")
	protected WebElement firstCategoryName;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/table/tbody/tr[1]/td[2]/a")
	protected WebElement firstCategoryUrl;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/table")
	protected WebElement categoriesTable;

	public CategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	public NewCategoryPage addCategory() {
		addCategory.click();
		return new NewCategoryPage(driver);
	}
	
	public String getFirstCategoryName() {
		return firstCategoryName.getText();
	}
	
	public String getFirstCategoryUrl() {
		return firstCategoryUrl.getText();
	}
	
	public EditCategoryPage editCategory(String cat) {
		driver.findElement(By.linkText(cat)).click();
		return new EditCategoryPage(driver);
	}
	
	public SiteCategoryPage seeCategoryArticles(String catUrl) {
		driver.findElement(By.linkText("/category/"+catUrl)).click();
		return new SiteCategoryPage(driver);
	}
	
	public boolean containsCategory(String cat) {
		return categoriesTable.getText().contains(cat);
	}


}
