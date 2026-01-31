package base;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.BaseNavBar;
import po.LoginPage;

public class BadLoginTest extends BaseTest {

	@Test
	public void badLogin() {
		new BaseNavBar(driver).logout();
		LoginPage login = new LoginPage(driver).setUsername("wrong").setPassword("wrong");
		login.login();
		assertTrue(login.isLoginFailed());
	}
	
}