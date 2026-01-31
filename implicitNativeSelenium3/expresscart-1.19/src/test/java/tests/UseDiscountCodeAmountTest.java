package tests;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.Home;
import po.PaymentPage;


public class UseDiscountCodeAmountTest extends BaseTest {


	@Test
	public void testExpressCartUseDiscountCodeAmount() throws Exception {
		int item_id = 1;
		goToHome();
		PaymentPage payment = new Home(driver)
			.account()
			.setEmail("test@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.loginAndGoHome(appUrl)
			.goToProduct(item_id)
			.addToCart()
			.openCartLogged()
			.checkout()
			.continueToShipping()
			.goToPayment()
			.setDiscountCode("discount000")
			.addDiscountCode(6000);
		
		assertTrue(payment.containsDiscountText("Discount: £3.00"));
	}



}
