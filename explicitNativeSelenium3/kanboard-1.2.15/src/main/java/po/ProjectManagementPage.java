package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

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
	
	protected Wait wait;

	
	public ProjectManagementPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public ProjectManagementPage newTask() {
		wait.waitClickability(projectDropDown);
		projectDropDown.click();
		wait.waitClickability(newTask);
		newTask.click();
		return new ProjectManagementPage(driver);
	}
	
	public ProjectManagementPage setNewTaskName(String name) {
		wait.waitClickability(titleTask);
		titleTask.sendKeys(name);
		return this;
	}
	
	public ProjectManagementPage saveNewTask() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new ProjectManagementPage(driver);
	}
	
	public String getFirstTaskName() {
		wait.waitVisibility(firstTaskName);
		return firstTaskName.getText();
	}
	
	public String getErrorMessage() {
		wait.waitVisibility(errorMsg);
		return errorMsg.getText();
	}
	
	
	

}
