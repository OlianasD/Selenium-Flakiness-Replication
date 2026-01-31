package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLoginPage;
import po.DiscountCodesPage;


public class AddDiscountCodePercentTest extends BaseTest {

	@Test
	public void testExpressCartAddDiscountCodePercent() throws Exception {
		goToAdminHome();
		DiscountCodesPage codes = new AdminLoginPage(driver)
			.setEmail("owner@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.doLogin()
			.discountCodes()
			.newDiscount()
			.setCode("discperc000")
			.setType("Percent")
			.setValue("50")
			.setStart("12/02/2023 00:00")
			.setEnd("12/02/2030 00:00")
			.addDiscount()
			.discountCodes();
		assertEquals("Code:  discperc000", codes.getIthDiscountCode(6));

		
	}


}
