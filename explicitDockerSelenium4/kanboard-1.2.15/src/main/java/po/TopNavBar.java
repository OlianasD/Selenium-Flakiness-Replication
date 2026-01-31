package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class TopNavBar extends PageObject {
	
	@FindBy(xpath =  "/html/body/header/div[3]/div[2]/a/i")
	protected WebElement settingsMenu;
	
	@FindBy(linkText =  "Settings")
	protected WebElement settings;
	
	@FindBy(linkText =  "Users management")
	protected WebElement usrMgmt;
	
	protected Wait wait;

	public TopNavBar(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public SettingsPage goToSettings() {
		wait.waitClickability(settingsMenu);
		settingsMenu.click();
		wait.waitClickability(settings);
		settings.click();
		return new SettingsPage(driver);
	}
	
	public UsersManagementPage usersManagement() {
		wait.waitClickability(settingsMenu);
		settingsMenu.click();
		wait.waitClickability(usrMgmt);
		usrMgmt.click();
		return new UsersManagementPage(driver);
	}

}
