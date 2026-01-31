package tests;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AddCategoryPage;
import po.PrestaLogin;


public class AddEmptyCategory extends BaseTest {
		
	@Test
	public void test_add_empty_category(){
		AddCategoryPage category = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToCategories()
				.clickAddCategory()
				.submitEmptyCategory();
		//assertEquals("The field name is required at least in your default language.", category.getAlertMessage());
		assertTrue(category.waitForAlertTextToBe("The field name is required at least in your default language."));
	}
}
