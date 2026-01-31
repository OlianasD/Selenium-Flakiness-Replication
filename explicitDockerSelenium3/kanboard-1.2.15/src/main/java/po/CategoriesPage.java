package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class CategoriesPage extends ProjectSidebar {
	
	@FindBy(linkText = "Add a new category")
	protected WebElement addCategory;
	
	@FindBy(id =  "form-name")
	protected WebElement formName;
	
	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div/div/button")
	protected WebElement saveBtn;
	
	@FindBy(className = "form-errors")
	protected WebElement errorMsg;
	
	protected Wait wait;

	public CategoriesPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public CategoriesPage addCategory() {
		wait.waitClickability(addCategory);
		addCategory.click();
		return new CategoriesPage(driver);
	}
	
	public CategoriesPage setName(String name) {
		wait.waitClickability(formName);
		formName.sendKeys(name);
		return this;
	}
	
	public CategoriesPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new CategoriesPage(driver);
	}
	
	public String getCategoryName() {
		By locator = By.xpath("//*[@id=\"main\"]/section/div[2]/table/tbody/tr[2]/td[1]");
		wait.waitVisibility(locator);
		return driver.findElement(locator).getText();
	}
	
	public String getErrorMessage() {
		wait.waitVisibility(errorMsg);
		return errorMsg.getText();
	}

}
