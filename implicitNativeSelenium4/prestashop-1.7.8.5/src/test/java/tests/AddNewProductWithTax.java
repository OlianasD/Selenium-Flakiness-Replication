package tests;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.PrestaLogin;
import po.PricesPage;

public class AddNewProductWithTax extends BaseTest
{
		  
		@Test
		public void test_add_new_product_with_tax(){
			 PricesPage prices = new PrestaLogin(driver)
					.loginToPresta(adminMail, adminPsw)
					.goToProducts()
					.addNewProduct()
					.prices()
					.chooseTaxRules22()
					.setPretaxRetail("10");
			 
			 
			 assertEquals(prices.getFinalPrice(), "€12.20");
			
		 }
	}
