package tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.CurrencyRatesPage;
import po.LoginPage;





public class AddNewCurrencyRate extends BaseTest {

		  
	@Test
	public void addNewCurrencyRate() {
		CurrencyRatesPage currencies = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.goToSettings()
				.currencyRates()
				.addCurrencyRate()
				.setRate("1.2")
				.save();
		
		assertEquals("USD", currencies.getRateCurrency());
		assertEquals("1.20", currencies.getRateValue());  
	}

}
