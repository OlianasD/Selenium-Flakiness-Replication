package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.NewContentPage;

public class ChangePostDateTest extends BaseTest {
	
	@Test
	public void changePostDate() {
		NewContentPage contentPage = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.content()
				.editFirstContent()
				.options()
				.advanced()
				.setDate("2022-08-03 14:42:26")
				.options()
				.saveAndStay()
				.options()
				.advanced();
		assertEquals("2022-08-03 14:42:26", contentPage.getDate());
	}
}