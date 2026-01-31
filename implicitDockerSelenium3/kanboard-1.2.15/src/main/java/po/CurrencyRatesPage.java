package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CurrencyRatesPage extends SettingsSidebar {
	
	@FindBy(xpath = "//*[@id=\"config-section\"]/div[2]/div[2]")
	protected WebElement referenceCurrency;
	
	@FindBy(linkText = "Change reference currency")
	protected WebElement changeReferenceCurrency;
	
	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div/div/button")
	protected WebElement saveBtn;
	
	@FindBy(linkText = "Add or change currency rate")
	protected WebElement addCurrencyRate;
	
	@FindBy(id = "form-rate")
	protected WebElement rate;
	
	@FindBy(xpath ="//*[@id=\"config-section\"]/div[2]/table/tbody/tr[2]/td[1]/strong")
	protected WebElement rateCurrency;
	
	@FindBy(xpath = "//*[@id=\"config-section\"]/div[2]/table/tbody/tr[2]/td[2]")
	protected WebElement rateValue;

	public CurrencyRatesPage(WebDriver driver) {
		super(driver);
	}
	
	public CurrencyRatesPage changeReferenceCurrency() {
		changeReferenceCurrency.click();
		return new CurrencyRatesPage(driver);
	}
	
	public CurrencyRatesPage selectCurrency(String curr) {
		new Select(driver.findElement(By.id("form-application_currency"))).selectByVisibleText(curr);
		return this;
	}
	
	public CurrencyRatesPage save() {
		saveBtn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new CurrencyRatesPage(driver);
	}
	
	public CurrencyRatesPage addCurrencyRate() {
		addCurrencyRate.click();
		return new CurrencyRatesPage(driver);
	}
	
	public String getReferenceCurrency() {
		return referenceCurrency.getText();
	}
	
	public CurrencyRatesPage setRate(String rt) {
		rate.sendKeys(rt);
		return this;
	}
	
	public String getRateCurrency() {
		return rateCurrency.getText();
	}
	
	public String getRateValue() {
		return rateValue.getText();
	}
	
	

}
