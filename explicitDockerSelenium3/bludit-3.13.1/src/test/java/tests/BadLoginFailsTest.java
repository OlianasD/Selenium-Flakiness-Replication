package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminLogin;

public class BadLoginFailsTest extends BaseTest {
	
	@Test
	public void badLogin_Fails() {
		AdminLogin login = new AdminLogin(driver)
				.setUsername(username)
				.setPassword("wrongpassword")
				.badLogin();
		
		assertTrue(login.isAlertVisible());
		assertEquals("Username or password incorrect", login.getAlertText());
	}
}