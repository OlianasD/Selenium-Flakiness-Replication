package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralSettingsPage extends GeneralSettingsAbstractPage {

	public GeneralSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public GeneralSettingsPage setFooter(String ft) {
		WebElement footer = wait.waitClickability(By.name("footer"));
		footer.clear();
		footer.sendKeys(ft);
		return this;
	}
	
	public GeneralSettingsPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new GeneralSettingsPage(driver);
	}


	public boolean footerTextToBe(String text) {
		wait.waitClickabilityRefreshed(By.name("footer"));
		return wait.waitForAttributeToBe(By.name("footer"), "value", text);
	}


	
	

}
