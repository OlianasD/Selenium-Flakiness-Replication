package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class SwimlanesPage extends ProjectSidebar {
	
	@FindBy(linkText = "Add a new swimlane")
	protected WebElement addSwimlane;
	
	@FindBy(id =  "form-name")
	protected WebElement formName;
	
	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div[2]/div/button")
	protected WebElement saveBtn;
	
	@FindBy(className = "form-errors")
	protected WebElement errorMsg;

	public SwimlanesPage(WebDriver driver) {
		super(driver);
	}
	
	public SwimlanesPage addSwimlane() {
		wait.waitClickability(addSwimlane);
		addSwimlane.click();
		return new SwimlanesPage(driver);
	}
	
	public SwimlanesPage setName(String name) {
		wait.waitClickability(formName);
		formName.sendKeys(name);
		return this;
	}
	
	public SwimlanesPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new SwimlanesPage(driver);
	}
	
	public String getLastSwimlaneName() {
		By locator = By.xpath("//*[@id=\"main\"]/section/div[2]/table/tbody/tr[2]/td[1]");
		wait.waitVisibility(locator);
		return driver.findElement(locator).getText();
	}
	
	public String getErrorMessage() {
		wait.waitVisibility(errorMsg);
		return errorMsg.getText();
	}
	
	

}
