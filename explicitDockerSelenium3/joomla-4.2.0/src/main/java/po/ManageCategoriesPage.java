package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageCategoriesPage extends SiteAdminPageObject {
	
	@FindBy(className = "button-new")
	protected WebElement addCategoryBtn;
	
	public ManageCategoriesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CreateCategoryPage addCategory() {
		wait.waitClickability(addCategoryBtn);
		addCategoryBtn.click();
		return new CreateCategoryPage(driver);
	}
	
	public boolean containsCategory(String title) {
		return wait.waitClickability(By.id("categoryList")).getText().contains(title);
	}
	
	public ManageCategoriesPage selectThirdCategory() {
		wait.waitClickability(By.id("cb2")).click();
		return this;
	}
	
	public ManageCategoriesPage deleteSelectedCategory() {
		wait.waitClickability(By.xpath("//*[@id=\"toolbar-status-group\"]/button")).click();
		wait.waitClickability(By.xpath("//*[@id=\"status-group-children-trash\"]/button")).click();
		return new ManageCategoriesPage(driver);
	}
	
	public String getAlertMessage() {
		return wait.waitVisibility(By.className("alert-message")).getText();
	}

}
