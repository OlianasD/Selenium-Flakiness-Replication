package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends ProjectSidebar {
	
	@FindBy(linkText = "Add a new category")
	protected WebElement addCategory;
	
	@FindBy(id =  "form-name")
	protected WebElement formName;
	
	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div/div/button")
	protected WebElement saveBtn;
	
	@FindBy(className = "form-errors")
	protected WebElement errorMsg;

	public CategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	public CategoriesPage addCategory() {
		addCategory.click();
		return new CategoriesPage(driver);
	}
	
	public CategoriesPage setName(String name) {
		formName.sendKeys(name);
		return this;
	}
	
	public CategoriesPage save() {
		saveBtn.click();
		return new CategoriesPage(driver);
	}
	
	public String getCategoryName() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/section/div[2]/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public String getErrorMessage() {
		return errorMsg.getText();
	}

}
