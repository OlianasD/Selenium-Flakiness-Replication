package base;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import po.ManageCategoriesPage;

public class AddCategory extends BaseTest {
	
	@Test
	public void addCategory() {
		String title = "Test Category 001";
		
		ManageCategoriesPage cats = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.categories()
			.addCategory()
			.setTitle(title)
			.save();
		
		assertTrue(cats.containsCategory(title));
		cats.logout();
	}
}
