package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AddProductPage;
import po.PrestaLogin;

public class AddEmptyProduct extends BaseTest {

	@Test()
	public void test_add_empty_product(){
		
		AddProductPage product = new PrestaLogin(driver)
			.loginToPresta(adminMail, adminPsw)
			.goToProducts()
			.addNewProduct()
			.submitProduct();
		
		//assertEquals("This value should not be blank.", product.getAlertMessage());
		assertTrue(product.waitForAlertMessageToBe("This value should not be blank."));
			

			
	}
		 
}

