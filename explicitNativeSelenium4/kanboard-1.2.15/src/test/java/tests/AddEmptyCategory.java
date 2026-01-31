package tests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.CategoriesPage;
import po.LoginPage;

public class AddEmptyCategory extends BaseTest {
	
	@Test()
	public void addEmptyCategory() {
		CategoriesPage categories = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.firstProjectSummary()
				.categories()
				.addCategory()
				.save();
		
		assertEquals("The name is required", categories.getErrorMessage());

		  
	}
}
