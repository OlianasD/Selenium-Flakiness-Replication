package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminLoginPage;
import po.NewDiscountPage;


public class AddEmptyDiscountCodeTest extends BaseTest {



	@Test
	public void testExpressCartAddEmptyDiscountCode() throws Exception {
		goToAdminHome();
		NewDiscountPage code = new AdminLoginPage(driver)
			.setEmail("owner@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.doLogin()
			.discountCodes()
			.newDiscount()
			.addDiscountError();
		
		assertTrue(code.discountCodeHasError());
		assertTrue(code.discountValueHasError());
		
		
	}



}
