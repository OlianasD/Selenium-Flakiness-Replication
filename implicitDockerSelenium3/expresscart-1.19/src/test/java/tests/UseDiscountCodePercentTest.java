package tests;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.Home;
import po.PaymentPage;


public class UseDiscountCodePercentTest extends BaseTest {


	@Test
	public void testExpressCartUseDiscountCodePercent() throws Exception {
		goToHome();
		int item_id = 1;
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
				.setDiscountCode("discperc000")
				.addDiscountCode(6000);
		
			assertTrue(payment.containsDiscountText("Discount: £7.98"));
	}


}
