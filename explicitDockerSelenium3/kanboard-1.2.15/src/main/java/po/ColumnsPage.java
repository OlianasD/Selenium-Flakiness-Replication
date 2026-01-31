package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ColumnsPage extends ProjectSidebar {

	@FindBy(linkText = "Add a new column")
	protected WebElement addColumn;

	@FindBy(id = "form-title")
	protected WebElement formTitle;

	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div[2]/div/button")
	protected WebElement saveBtn;

	@FindBy(className = "form-errors")
	protected WebElement errorMsg;


	public ColumnsPage(WebDriver driver) {
		super(driver);
	}

	public ColumnsPage addColumn() {
		wait.waitClickability(addColumn);
		addColumn.click();
		return new ColumnsPage(driver);
	}

	public ColumnsPage setColumnName(String name) {
		wait.waitClickability(formTitle);
		formTitle.sendKeys(name);
		return this;
	}

	public ColumnsPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new ColumnsPage(driver);
	}

	public String getLastColumnName() {
		By locator = By.xpath("//*[@id=\"main\"]/section/div[2]/table/tbody/tr[5]/td[1]");
		wait.waitVisibility(locator);
		return driver.findElement(locator).getText();
	}

	public String getErrorMessage() {
		wait.waitVisibility(errorMsg);
		return errorMsg.getText();
	}

}
