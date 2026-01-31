package tests;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.CategoriesPage;
import po.PrestaLogin;


public class AddNewCategory extends BaseTest {
		
	@Test
	public void test_add_category(){
		CategoriesPage categories = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToCategories()
				.clickAddCategory()
				.submitCategory("Winters Collection");
		assertTrue(categories.getSuccessMessage().contains("Successful creation"));
	}
}
