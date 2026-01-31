package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteSocialsPage extends GeneralSettingsAbstractPage {
	
	@FindBy(id = "jsinstagram")
	protected WebElement instagram;
	

	public SiteSocialsPage(WebDriver driver) {
		super(driver);
	}
	
	public SiteSocialsPage setInstagram(String ig) {
		instagram.clear();
		instagram.sendKeys(ig);
		return this;
	}
	
	public SiteSocialsPage save() {
		saveBtn.click();
		return new SiteSocialsPage(driver);
	}
	
	public String getInstagram() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instagram.getAttribute("value");
	}

}
