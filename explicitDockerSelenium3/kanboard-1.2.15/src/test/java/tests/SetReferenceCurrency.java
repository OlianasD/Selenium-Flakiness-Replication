package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.CurrencyRatesPage;
import po.LoginPage;





public class SetReferenceCurrency extends BaseTest {


		  
	@Test()
	public void setReference() {
		CurrencyRatesPage currencies = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.goToSettings()
				.currencyRates()
				.changeReferenceCurrency()
				.selectCurrency("EUR - Euro")
				.save();
		
		assertTrue(currencies.referenceCurrencyHasText("Reference currency: EUR"));
			  
	}
		  
		  
		  
}
