package tests;


import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.AdminLoginPage;
import po.DiscountCodesPage;


public class DeleteDiscountCodeAmountTest extends BaseTest {

	@Test
	public void testExpressCartAddDiscountCodeAmount() throws Exception {
		goToAdminHome();
		DiscountCodesPage codes = new AdminLoginPage(driver)
			.setEmail("owner@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.doLogin()
			.discountCodes()
			.deleteDiscountCode("discount000")
			.discountCodes();
		
		assertFalse(codes.containsCode("discount000"));
		
	}



}
