package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralSettingsPage extends GeneralSettingsAbstractPage {

	@FindBy(id = "jsfooter")
	protected WebElement footer;
	
	public GeneralSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public GeneralSettingsPage setFooter(String ft) {
		footer.clear();
		footer.sendKeys(ft);
		return this;
	}
	
	public GeneralSettingsPage save() {
		saveBtn.click();
		return new GeneralSettingsPage(driver);
	}
	
	public String getFooter() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return footer.getAttribute("value");
	}
	
	

}
