package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectManagementPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[1]/div/a")
	protected WebElement projectDropDown;
	
	@FindBy(xpath = "//*[@id=\"dropdown\"]/ul/li[3]/a")
	protected WebElement newTask;
	
	@FindBy(xpath = "//*[@id=\"form-title\"]")
	protected WebElement titleTask;
	
	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div/div[4]/div/div/button")
	protected WebElement saveBtn;
	
	@FindBy(xpath = "//*[@id=\"board\"]/tbody/tr[2]/td[1]/div[1]/div/div[2]/div[3]/a")
	protected WebElement firstTaskName;
	
	@FindBy(className = "form-errors")
	protected WebElement errorMsg;

	
	public ProjectManagementPage(WebDriver driver) {
		super(driver);
	}
	
	public ProjectManagementPage newTask() {
		projectDropDown.click();
		newTask.click();
		return new ProjectManagementPage(driver);
	}
	
	public ProjectManagementPage setNewTaskName(String name) {
		titleTask.sendKeys(name);
		return this;
	}
	
	public ProjectManagementPage saveNewTask() {
		saveBtn.click();
		return new ProjectManagementPage(driver);
	}
	
	public String getFirstTaskName() {
		return firstTaskName.getText();
	}
	
	public String getErrorMessage() {
		return errorMsg.getText();
	}
	
	
	

}
