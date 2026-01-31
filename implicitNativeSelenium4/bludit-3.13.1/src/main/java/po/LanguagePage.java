package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LanguagePage extends GeneralSettingsAbstractPage {

	public LanguagePage(WebDriver driver) {
		super(driver);
	}
	
	public LanguagePage setLanguage(String lang) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Select(driver.findElement(By.id("jslanguage"))).selectByVisibleText(lang);
		return this;
	}
	
	public LanguagePage save() {
		saveBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new LanguagePage(driver);
	}
	
	public String getLanguage() {
		return new Select(driver.findElement(By.id("jslanguage"))).getFirstSelectedOption().getText();
	}

}
