package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLoginPage;
import po.DiscountCodesPage;


public class AddDiscountCodeAmountTest extends BaseTest {



	@Test
	public void testExpressCartAddDiscountCodeAmount() throws Exception {
		goToAdminHome();
		DiscountCodesPage codes = new AdminLoginPage(driver)
			.setEmail("owner@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.doLogin()
			.discountCodes()
			.newDiscount()
			.setCode("discount000")
			.setValue("3")
			.setStart("12/02/2024 00:00")
			.setEnd("12/02/2030 00:00")
			.addDiscount()
			.discountCodes();
		assertEquals("Code:  discount000", codes.getIthDiscountCode(5));
		
	}



}
