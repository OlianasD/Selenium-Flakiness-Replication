package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		addColumn.click();
		return new ColumnsPage(driver);
	}

	public ColumnsPage setColumnName(String name) {
		formTitle.sendKeys(name);
		return this;
	}

	public ColumnsPage save() {
		saveBtn.click();
		return new ColumnsPage(driver);
	}

	public String getLastColumnName() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/section/div[2]/table/tbody/tr[5]/td[1]")).getText();
	}

	public String getErrorMessage() {
		return errorMsg.getText();
	}

}
