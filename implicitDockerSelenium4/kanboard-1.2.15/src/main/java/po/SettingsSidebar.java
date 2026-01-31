package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsSidebar extends TopNavBar {
	
	@FindBy(linkText = "Currency rates")
	protected WebElement currencyRates;
	
	@FindBy(linkText = "Application settings")
	protected WebElement appSettings;
	
	@FindBy(linkText =  "Board settings")
	protected WebElement boardSettings;

	public SettingsSidebar(WebDriver driver) {
		super(driver);
	}
	
	public CurrencyRatesPage currencyRates() {
		currencyRates.click();
		return new CurrencyRatesPage(driver);
	}
	
	public ApplicationSettingsPage appSettings() {
		appSettings.click();
		return new ApplicationSettingsPage(driver);
	}
	
	public BoardSettingsPage boardSettings() {
		boardSettings.click();
		return new BoardSettingsPage(driver);
	}

}
