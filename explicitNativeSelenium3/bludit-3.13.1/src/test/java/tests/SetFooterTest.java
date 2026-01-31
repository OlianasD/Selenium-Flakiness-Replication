package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminLogin;
import po.GeneralSettingsPage;

public class SetFooterTest extends BaseTest {

	@Test
	public void setFooter() {
		GeneralSettingsPage general = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.general()
				.general()
				.setFooter("E2E Web testing benchmark")
				.save();
		
		assertTrue(general.footerTextToBe("E2E Web testing benchmark"));
	}
	
}
