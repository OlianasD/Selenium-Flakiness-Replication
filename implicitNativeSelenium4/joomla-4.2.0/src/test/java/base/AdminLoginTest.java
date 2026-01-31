package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ProfilePageInfo;

public class AdminLoginTest extends BaseTest {
	
	@Test
	public void adminLoginTest() {
		ProfilePageInfo profile = loginAsAdmin();
		assertEquals("Super User", profile.getName());
		profile.adminLogout();
	}
	
}
