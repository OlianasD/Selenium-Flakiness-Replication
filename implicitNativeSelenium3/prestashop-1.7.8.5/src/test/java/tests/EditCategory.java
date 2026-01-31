package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.CategoriesPage;
import po.PrestaLogin;

public class EditCategory extends BaseTest {
	
	@Test
	public void test_edit_category(){
		CategoriesPage categories = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToCategories()
				.editCategory()
				.submitCategory("Fall Collection");
		
		assertTrue(categories.getSuccessMessage().contains("Successful update"));
	}	 
}
