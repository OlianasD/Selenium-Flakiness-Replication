package tests;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.PrestaLogin;
import po.ProductsPage;

public class EditProduct extends BaseTest {

		 @Test()
		 public void test_edit_product(){
			 ProductsPage products = new PrestaLogin(driver)
					.loginToPresta(adminMail, adminPsw)
					.goToProducts()
					.editProduct()
					.addNameOfProduct("Deep Blue Jacket")
					.submitProduct()
					.backToCatalog();
						
			 assertEquals("Deep Blue Jacket", products.getFirstProductName());
			 
		 }
		 
}
