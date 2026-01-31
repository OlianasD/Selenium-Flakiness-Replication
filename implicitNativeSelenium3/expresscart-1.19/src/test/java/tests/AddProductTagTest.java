package tests;




import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLoginPage;
import po.EditProductPage;


public class AddProductTagTest extends BaseTest {

	@Test
	public void testExpressCartAddProductTag() throws Exception {
		goToAdminHome();
		EditProductPage product = new AdminLoginPage(driver)
			.setEmail("owner@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.doLogin()
			.products()
			.goToProduct("NewProduct000")
			.setTag("tag000")
			.saveProduct();
		assertEquals("tag000", product.getLastTag());	
		
	}



}
