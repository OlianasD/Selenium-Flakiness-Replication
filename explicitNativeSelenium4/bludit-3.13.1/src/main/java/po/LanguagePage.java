package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Wait;

public class LanguagePage extends GeneralSettingsAbstractPage {
	
	protected Wait wait;

	public LanguagePage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public LanguagePage setLanguage(String lang) {
		WebElement langSelect = wait.waitClickability(By.name("language"));
		new Select(langSelect).selectByVisibleText(lang);
		return this;
	}
	
	public LanguagePage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new LanguagePage(driver);
	}
	
	public String getLanguage() {
		return new Select(wait.waitClickabilityRefreshed(By.name("language"))).getFirstSelectedOption().getText();
	}

}
