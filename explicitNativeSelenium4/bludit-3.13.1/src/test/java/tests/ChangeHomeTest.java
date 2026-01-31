package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.AdvancedSettingsPage;

public class ChangeHomeTest extends BaseTest {
	
	@Test
	public void changeHome() {
		AdvancedSettingsPage settings = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.general()
			.advanced()
			.setHome("Create your own content")
			.save();
		assertEquals("Create your own content", settings.getSelectedHome());
	}
	
}