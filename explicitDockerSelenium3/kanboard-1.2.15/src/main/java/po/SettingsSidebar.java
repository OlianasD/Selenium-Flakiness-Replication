package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsSidebar extends TopNavBar {
	
	@FindBy(linkText = "Currency rates")
	protected WebElement currencyRates;
	
	@FindBy(linkText =  "Board settings")
	protected WebElement boardSettings;

	public SettingsSidebar(WebDriver driver) {
		super(driver);
	}
	
	public CurrencyRatesPage currencyRates() {
		wait.waitClickability(currencyRates);
		currencyRates.click();
		return new CurrencyRatesPage(driver);
	}
	
	public ApplicationSettingsPage appSettings() {
		wait.waitClickabilityRefreshed(By.linkText("Application settings")).click();
		/*try {
			wait.waitClickabilityRefreshed(By.linkText("Application settings")).click();
		} catch(WebDriverException e) {
			wait.waitClickabilityRefreshed(By.linkText("Application settings")).click();
		}*/
		return new ApplicationSettingsPage(driver);
	}
	
	public BoardSettingsPage boardSettings() {
		wait.waitClickability(boardSettings);
		boardSettings.click();
		return new BoardSettingsPage(driver);
	}

}
