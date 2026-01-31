package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLoginPage;

import po.ProductsPage;



public class AddProductTest extends BaseTest {

	@Test
	public void testExpressCartAddProduct() throws Exception {
			goToAdminHome();
			ProductsPage products = new AdminLoginPage(driver)
				.setEmail("owner@test.com")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.doLogin()
				.newProduct()
				.setTitle("NewProduct000")
				.setPrice("15.95")
				.setDescr("Description for product 000")
				.addProduct()
				.products();
			
			assertEquals(products.getFirstProductName(), "NewProduct000");	
		
	}


}
