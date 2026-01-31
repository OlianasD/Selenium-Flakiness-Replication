package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.ContentPage;

public class AddContentTest extends BaseTest {
	
	@Test
	public void addContentTest() {
		ContentPage content = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.newContent()
				.setTitle("Test Content")
				.saveAndReturnToContentPage();
		
		assertEquals("Test Content", content.getFirstContentTitle());
	}
}