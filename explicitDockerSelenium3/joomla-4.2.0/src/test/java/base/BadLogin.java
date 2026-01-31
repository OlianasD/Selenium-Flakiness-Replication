package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AuthorLoginPage;
import po.BaseNavBar;

public class BadLogin extends BaseTest {
	
	@Test
	public void badLogin() {
		AuthorLoginPage login = new BaseNavBar(driver)
				.authorLogin()
				.setUsername("administrator")
				.setPassword("wrongpassword")
				.badLogin();
		
		assertEquals("Username and password do not match or you do not have an account yet.", login.getAlertMessage());
	}
}