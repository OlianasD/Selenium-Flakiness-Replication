package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.CategoriesPage;

public class ChangeCategoryUrlTest extends BaseTest {
	
	@Test
	public void changeCategoryUrl() {

		CategoriesPage categories = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.categories()
				.editCategory("Category001")
				.setUrl("aaanewurl001")
				.save();
		
		assertEquals("/category/aaanewurl001", categories.getFirstCategoryUrl());
				
	}
}
