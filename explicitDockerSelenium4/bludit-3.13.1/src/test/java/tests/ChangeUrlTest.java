package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.ContentPage;

public class ChangeUrlTest extends BaseTest {
	
	@Test
	public void changeUrlTest() {
		ContentPage content = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.content()
			.editFirstContent()
			.options()
			.seo()
			.setUrl("new-post-url")
			.options()
			.saveAndReturnToContentPage()
			.content();
		
		assertEquals("/new-post-url", content.getFirstElementUrl());
		
	}
	
}
