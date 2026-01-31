package tests;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.CurrencyPage;
import po.PrestaLogin;

public class AddCurrency extends BaseTest {

	@Test
	public void test_add_currency(){
		CurrencyPage currency = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToCurrency()
				.clickAddCurrency()
				.addCurrency("Something", "STH", "10");
		assertTrue(currency.getSuccessMessage().contains("Successful creation"));
	}
}
