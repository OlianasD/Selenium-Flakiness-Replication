package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardSettingsPage extends SettingsSidebar {
	
	@FindBy(id = "form-board_public_refresh_interval")
	protected WebElement formInterval;
	
	@FindBy(xpath = "//*[@id=\"config-section\"]/div[2]/form/div/button")
	protected WebElement saveBtn;
	
	public BoardSettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public BoardSettingsPage setPublicrefreshIntgerval(String interval) {
		wait.waitClickability(formInterval);
		formInterval.clear();
		formInterval.sendKeys(interval);
		return this;
	}
	
	public BoardSettingsPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new BoardSettingsPage(driver);
	}
	
	public String getPublicRefreshInterval() {
		wait.waitVisibility(formInterval);
		return formInterval.getAttribute("value");
	}


}