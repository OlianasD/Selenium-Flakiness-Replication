package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCurrencyPage {
	WebDriver driver;

	@FindBy(id = "page-header-desc-currency-new_currency")
	WebElement addCurrency;

	@FindBy(id = "currency_names_1")
	WebElement name;

	@FindBy(id = "currency_iso_code")
	WebElement iso_code;

	@FindBy(id = "currency_exchange_rate")
	WebElement exchangeRate;

	@FindBy(id = "sign")
	WebElement sign;

	@FindBy(id = "save-button")
	WebElement submitCurrency;

	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div")
	WebElement alertMsg;

	@FindBy(xpath = "//*[@id=\"currency_form\"]/div/div[2]/div/div[2]/div")
	WebElement altCurrency;

	@FindBy(xpath = "//*[@id=\"currency_form\"]/div/div[2]/div/div[3]/div/div[3]/div")
	WebElement emptyNameAlert;

	@FindBy(xpath = "//*[@id=\"currency\"]/div[1]/div/div[2]/div")
	WebElement emptyIsoAlert;

	public AddCurrencyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddCurrency() {
		addCurrency.click();
	}

	public CurrencyPage addCurrency(String nameStr, String isoStr, String rate) {
		altCurrency.click();
		name.sendKeys(nameStr);
		iso_code.sendKeys(isoStr);
		exchangeRate.clear();
		exchangeRate.sendKeys(rate);
		submitCurrency.click();
		return new CurrencyPage(driver);
	}

	public AddCurrencyPage addEmptyCurrency() {
		submitCurrency.click();
		return new AddCurrencyPage(driver);
	}

	public String getAlertMessage() {
		return alertMsg.getText();
	}

	public String getEmptyIsoAlert() {
		return emptyIsoAlert.getText();
	}

	public String getEmptyNameAlert() {
		return emptyNameAlert.getText();
	}
}
