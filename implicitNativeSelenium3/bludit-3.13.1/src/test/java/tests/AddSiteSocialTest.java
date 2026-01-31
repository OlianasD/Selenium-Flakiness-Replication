package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.SiteSocialsPage;

public class AddSiteSocialTest extends BaseTest {
	
	@Test
	public void addSiteSocial() {
		SiteSocialsPage socials = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.general()
			.socials()
			.setInstagram("https://instagram.com/bludit595159516")
			.save();
		
		assertEquals("https://instagram.com/bludit595159516", socials.getInstagram());
	}
	
}
