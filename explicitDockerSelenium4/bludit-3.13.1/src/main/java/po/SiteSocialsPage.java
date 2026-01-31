package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class SiteSocialsPage extends GeneralSettingsAbstractPage {

	public SiteSocialsPage(WebDriver driver) {
		super(driver);
	}
	
	public SiteSocialsPage setInstagram(String ig) {
		WebElement instagram = wait.waitClickability(By.name("instagram"));
		instagram.clear();
		instagram.sendKeys(ig);
		return this;
	}
	
	public SiteSocialsPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new SiteSocialsPage(driver);
	}
	
	public String getInstagram() {
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		WebElement insta = wait.waitVisibility(By.name("instagram"));
		return insta.getAttribute("value");
	}

	public boolean isInstagramEqualTo(String expected) {
		wait.waitClickabilityRefreshed(By.name("instagram"));
		return wait.waitForAttributeToBe(By.name("instagram"), "value", expected);
	}

}
