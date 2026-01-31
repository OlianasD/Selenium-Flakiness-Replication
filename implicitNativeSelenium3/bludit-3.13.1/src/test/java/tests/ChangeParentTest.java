package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.NewContentPage;

public class ChangeParentTest extends BaseTest {
	
	@Test
	public void changeParent() {
		NewContentPage contentPage = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.content()
				.editFirstContent()
				.options()
				.advanced()
				.setParent("Create your own content")
				.options()
				.saveAndStay()
				.options()
				.advanced();
		
		assertEquals("Create your own content", contentPage.getSelectedParent());
	}
}
