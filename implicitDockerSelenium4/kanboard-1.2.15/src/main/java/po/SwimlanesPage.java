package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		addSwimlane.click();
		return new SwimlanesPage(driver);
	}
	
	public SwimlanesPage setName(String name) {
		formName.sendKeys(name);
		return this;
	}
	
	public SwimlanesPage save() {
		saveBtn.click();
		return new SwimlanesPage(driver);
	}
	
	public String getLastSwimlaneName() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/section/div[2]/table/tbody/tr[2]/td[1]")).getText();
	}
	
	public String getErrorMessage() {
		return errorMsg.getText();
	}
	
	

}
