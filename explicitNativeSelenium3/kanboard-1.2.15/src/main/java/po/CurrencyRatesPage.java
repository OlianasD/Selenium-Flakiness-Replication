package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Wait;

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
		wait.waitClickability(changeReferenceCurrency);
		changeReferenceCurrency.click();
		return new CurrencyRatesPage(driver);
	}
	
	public CurrencyRatesPage selectCurrency(String curr) {
		By locator = By.id("form-application_currency");
		wait.waitClickability(locator);
		new Select(driver.findElement(locator)).selectByVisibleText(curr);
		return this;
	}
	
	public CurrencyRatesPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new CurrencyRatesPage(driver);
	}
	
	public CurrencyRatesPage addCurrencyRate() {
		wait.waitClickability(addCurrencyRate);
		addCurrencyRate.click();
		return new CurrencyRatesPage(driver);
	}

	public boolean referenceCurrencyHasText(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"config-section\"]/div[2]/div[2]"), expected);
	}
	
	public CurrencyRatesPage setRate(String rt) {
		wait.waitClickability(rate);
		rate.sendKeys(rt);
		return this;
	}
	
	public String getRateCurrency() {
		wait.waitVisibility(rateCurrency);
		return rateCurrency.getText();
	}
	
	public String getRateValue() {
		wait.waitVisibility(rateValue);
		return rateValue.getText();
	}
	
	

}
