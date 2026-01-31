package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class UserRightsPage extends PageObject {
	
	@FindBy(id = "username")
	protected WebElement searchUserField;
	
	@FindBy(xpath = "//*[@id=\"mw-userrights-form1\"]/fieldset/input[2]")
	protected WebElement searchBtn;
	
	@FindBy(id = "wpGroup-sysop")
	protected WebElement adminCheckbox;
	
	@FindBy(id = "wpReason")
	protected WebElement reason;
	
	@FindBy(name = "saveusergroups")
	protected WebElement saveBtn;
	
	protected Wait wait;

	public UserRightsPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public UserRightsPage findUser(String user) {
		searchUserField.sendKeys(user);
		searchBtn.click();
		return new UserRightsPage(driver);
	}
	
	public UserRightsPage checkAdmin() {
		wait.waitClickability(adminCheckbox);
		adminCheckbox.click();
		return this;
	}
	
	public UserRightsPage setReason(String reason) {
		this.reason.sendKeys(reason);
		return this;
	}
	
	public UserRightsPage save() {
		saveBtn.click();
		return new UserRightsPage(driver);
	}
	
	public boolean isAdminChecked() {
		return wait.waitClickabilityRefreshed(By.id("wpGroup-sysop")).isSelected();
	}
	
	public String getLogEntry() {
		return wait.waitVisibility(By.xpath("//*[@id=\"mw-content-text\"]/ul/li")).getText();
	}
	
	
	

}
