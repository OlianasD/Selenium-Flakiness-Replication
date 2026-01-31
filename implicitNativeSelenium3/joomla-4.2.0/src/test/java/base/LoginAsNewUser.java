package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ProfilePageInfo;

public class LoginAsNewUser extends BaseTest {
	
	@Test
	public void loginAsNewUser() {
		String name ="Test User";
		String username = "tuser01";
		String password = "tpassword";
		
		ProfilePageInfo profile = new BaseNavBar(driver)
				.authorLogin()
				.setUsername(username)
				.setPassword(password)
				.login();
		
		assertEquals(name, profile.getName());
		profile.standardUserLogOut();
	}
}
