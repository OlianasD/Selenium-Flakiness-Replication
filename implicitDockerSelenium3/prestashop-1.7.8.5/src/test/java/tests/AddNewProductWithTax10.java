package tests;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.PrestaLogin;
import po.PricesPage;
public class AddNewProductWithTax10  extends BaseTest {

	@Test
	public void test_add_new_product_with_tax10(){
		PricesPage prices = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToProducts()
				.addNewProduct()
				.prices()
				.chooseTaxRules10()
				.setPretaxRetail("10");
		 
		 
		 assertEquals(prices.getFinalPrice(), "€11.00");
	}
}
