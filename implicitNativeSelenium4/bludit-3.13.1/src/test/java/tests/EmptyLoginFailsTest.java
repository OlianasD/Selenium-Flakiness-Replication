package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminLogin;

public class EmptyLoginFailsTest extends BaseTest {
	
	@Test
	public void emptyLogin_Fails() {
		AdminLogin login = new AdminLogin(driver)
				.setUsername("")
				.setPassword("")
				.badLogin();
		
		assertTrue(login.isAlertVisible());
		assertEquals("Username or password incorrect", login.getAlertText());
	}
}
