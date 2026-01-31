package tests;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AddToCartPage;
import po.PrestaLogin;

public class OutOfStockValidity extends BaseTest {

		@Test
		public void test_outofstock(){
			AddToCartPage order = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToOrders()
				.addOrder()
				.addCustomerName("John")
				.clickOnChooseCustomer()
				.addProductName("Blue")
				.addQuantity("4")
				.submitProductAndFail();
			
			assertTrue(order.getErrorMessage().contains("There are not enough products in stock."));
	}
}
