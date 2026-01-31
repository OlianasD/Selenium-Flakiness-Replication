package base;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.BaseNavBar;
import po.LoginPage;

public class LogoutTest extends BaseTest {

	@Test
	public void logout() {
		new BaseNavBar(driver).logout();
		LoginPage login = new LoginPage(driver);
		assertTrue(login.isLoginBtnDisplayed());
	}
	
}