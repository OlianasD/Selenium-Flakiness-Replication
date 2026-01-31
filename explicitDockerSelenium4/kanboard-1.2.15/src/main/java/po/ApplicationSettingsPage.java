package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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
		new Select(wait.waitClickability(By.id("form-application_language"))).selectByVisibleText(lang);
		return this;
	}
	
	public ApplicationSettingsPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new ApplicationSettingsPage(driver);
	}
	
	public String getSelectedLanguage() {
		return new Select(wait.waitClickabilityRefreshed(By.id("form-application_language"))).getFirstSelectedOption().getText();
		/*try {
			return new Select(wait.waitClickabilityRefreshed(By.id("form-application_language"))).getFirstSelectedOption().getText();
		} catch(WebDriverException e) {
			return new Select(wait.waitClickabilityRefreshed(By.id("form-application_language"))).getFirstSelectedOption().getText();
		}*/

	}
	
	public String getLanguageLabel() {
		wait.waitVisibility(languageLabel);
		return languageLabel.getText();
	}
	
}