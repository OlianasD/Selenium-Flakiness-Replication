package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.NewContentPage;

public class AssignCategoryTest extends BaseTest {
	
	@Test
	public void assignCategory() {
		NewContentPage content = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.content()
			.editFirstContent()
			.options()
			.setCategory("Category001")
			.options()
			.saveAndStay()
			.content()
			.editFirstContent()
			.options();
		
		assertEquals("Category001", content.getSelectedCategory());
	}
}