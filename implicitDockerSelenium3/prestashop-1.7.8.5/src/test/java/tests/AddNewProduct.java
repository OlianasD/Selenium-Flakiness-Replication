package tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import po.PrestaLogin;
import po.ProductsPage;

public class AddNewProduct extends BaseTest {

	@Test()
	public void test_add_new_product(){
		
		ProductsPage products = new PrestaLogin(driver)
			.loginToPresta(adminMail, adminPsw)
			.goToProducts()
			.addNewProduct()
			.addNameOfProduct("Blue Jacket3")
			.submitProduct()
			.backToCatalog();
			
		assertEquals("Blue Jacket3", products.getFirstProductName());
			
	}
		 
}

