package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.AdvancedSettingsPage;

public class OrderByPositionTest extends BaseTest {
	
	@Test
	public void orderByPosition() {
		AdvancedSettingsPage settings = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.general()
				.advanced()
				.setPostsOrder("Position")
				.save();
		
		assertEquals("Position", settings.getPostsOrder());
	}
	
	
}