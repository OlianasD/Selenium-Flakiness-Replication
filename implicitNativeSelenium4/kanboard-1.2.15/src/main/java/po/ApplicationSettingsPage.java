package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ApplicationSettingsPage extends SettingsSidebar {
	
	@FindBy(xpath = "//*[@id=\"config-section\"]/div[2]/form/div/button")
	protected WebElement saveBtn;
	
	@FindBy(xpath ="//*[@id=\"config-section\"]/div[2]/form/fieldset[1]/label[2]")
	protected WebElement languageLabel;

	public ApplicationSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	
	public ApplicationSettingsPage selectLanguage(String lang) {
		new Select(driver.findElement(By.id("form-application_language"))).selectByVisibleText(lang);
		return this;
	}
	
	public ApplicationSettingsPage save() {
		saveBtn.click();
		return new ApplicationSettingsPage(driver);
	}
	
	public String getSelectedLanguage() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return new Select(driver.findElement(By.id("form-application_language"))).getFirstSelectedOption().getText();
	}
	
	public String getLanguageLabel() {
		return languageLabel.getText();
	}
	
}