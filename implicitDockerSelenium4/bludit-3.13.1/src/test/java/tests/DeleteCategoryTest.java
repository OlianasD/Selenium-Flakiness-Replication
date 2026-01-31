package tests;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.AdminLogin;
import po.CategoriesPage;

public class DeleteCategoryTest extends BaseTest {
	
	@Test
	public void deleteCategory() {
		CategoriesPage categories = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.categories()
			.editCategory("Category001")
			.delete()
			.confirmDelete();
		
		assertFalse(categories.containsCategory("Category001"));
	}
}