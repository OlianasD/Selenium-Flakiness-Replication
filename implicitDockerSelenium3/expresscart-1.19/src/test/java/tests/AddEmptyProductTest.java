package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import po.AdminLoginPage;
import po.NewProductPage;

public class AddEmptyProductTest extends BaseTest {

	@Test
	public void testExpressCartAddEmptyProduct() throws Exception {
		goToAdminHome();
		NewProductPage product = new AdminLoginPage(driver)
				.setEmail("owner@test.com")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.doLogin()
				.newProduct()
				.addProductError();
		
		assertTrue(product.productTitleHasError());
		assertTrue(product.productPriceHasError());
	}

}
