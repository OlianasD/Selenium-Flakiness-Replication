package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public UserRightsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public UserRightsPage findUser(String user) {
		searchUserField.sendKeys(user);
		searchBtn.click();
		return new UserRightsPage(driver);
	}
	
	public UserRightsPage checkAdmin() {
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminCheckbox.isSelected();
	}
	
	public String getLogEntry() {
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/ul/li")).getText();
	}
	
	
	

}
