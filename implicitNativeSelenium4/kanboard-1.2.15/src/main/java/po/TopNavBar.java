package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavBar extends PageObject {
	
	@FindBy(xpath =  "/html/body/header/div[3]/div[2]/a/i")
	protected WebElement settingsMenu;
	
	@FindBy(linkText =  "Settings")
	protected WebElement settings;
	
	@FindBy(linkText =  "Users management")
	protected WebElement usrMgmt;

	public TopNavBar(WebDriver driver) {
		super(driver);
	}
	
	public SettingsPage goToSettings() {
		settingsMenu.click();
		settings.click();
		return new SettingsPage(driver);
	}
	
	public UsersManagementPage usersManagement() {
		settingsMenu.click();
		usrMgmt.click();
		return new UsersManagementPage(driver);
	}

}
