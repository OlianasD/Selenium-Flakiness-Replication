package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.CategoriesPage;
import po.LoginPage;




public class AddNewCategory extends BaseTest {
		  
		@Test()
		public void addNewCategory() {
			CategoriesPage categories = new LoginPage(driver)
					.loginToKanboard("admin", password)
					.firstProjectSummary()
					.categories()
					.addCategory()
					.setName("New Category 2")
					.save();
			
			assertTrue(categories.getCategoryName().contains("New Category 2"));
			  
		}
		  

		  
		  
}
