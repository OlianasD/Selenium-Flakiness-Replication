package tests;

import static org.junit.Assert.assertEquals;


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
		
		assertEquals("Reference currency: EUR", currencies.getReferenceCurrency());
			  
	}
		  
		  
		  
}
