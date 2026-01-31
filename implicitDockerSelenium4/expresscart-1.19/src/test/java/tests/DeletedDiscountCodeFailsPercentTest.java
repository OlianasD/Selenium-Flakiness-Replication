package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.Home;
import po.PaymentPage;


public class DeletedDiscountCodeFailsPercentTest extends BaseTest {


	@Test
	public void testExpressCartDeletedDiscountCodeFailsPercent() throws Exception {
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
			.setDiscountCode("discperc000")
			.addDiscountCode(1000);
		assertEquals("Discount code is invalid or expired", payment.getDangerAlertText());
		

		
	}


}
