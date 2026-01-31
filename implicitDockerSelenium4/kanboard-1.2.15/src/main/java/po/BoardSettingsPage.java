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
		formInterval.clear();
		formInterval.sendKeys(interval);
		return this;
	}
	
	public BoardSettingsPage save() {
		saveBtn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BoardSettingsPage(driver);
	}
	
	public String getPublicRefreshInterval() {
		return formInterval.getAttribute("value");
	}


}