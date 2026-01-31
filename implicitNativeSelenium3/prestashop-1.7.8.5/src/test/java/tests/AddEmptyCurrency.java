package tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import po.AddCurrencyPage;
import po.PrestaLogin;

public class AddEmptyCurrency extends BaseTest {

	@Test
	public void test_add_empty_currency(){
		AddCurrencyPage currency = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToCurrency()
				.clickAddCurrency()
				.addEmptyCurrency();
		
		assertEquals("The field names is required at least in your default language.", currency.getEmptyNameAlert());
		assertEquals("The \"ISO code\" field is required.", currency.getEmptyIsoAlert());
	}
}
