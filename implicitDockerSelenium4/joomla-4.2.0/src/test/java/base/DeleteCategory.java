package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import po.ManageCategoriesPage;

public class DeleteCategory extends BaseTest {
	
	@Test
	public void deleteCategory() {
		String category = "Test Category 001";
		String expectedAlert = "Category trashed.";
		
		ManageCategoriesPage categories = loginAsAdmin()
				.siteAdmin()
				.setUsername("administrator")
				.setPassword(rootPassword)
				.login()
				.categories()
				.selectThirdCategory()
				.deleteSelectedCategory();
		
		assertEquals(expectedAlert, categories.getAlertMessage());
		assertFalse(categories.containsCategory(category));
		categories.logout();
	}
}