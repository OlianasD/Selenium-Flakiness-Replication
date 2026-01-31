package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.SocialNetworksPage;

public class AddSocialsTest extends BaseTest {
	
	@Test
	public void addSocials() {
		SocialNetworksPage socials = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.users()
			.editFirstUser()
			.socials()
			.setFb("https://www.facebook.com/some_fake_user_name_52432562135863")
			.setIg("https://instagram.com/some_fake_user_name_52432562135863")
			.save()
			.editFirstUser()
			.socials();
		assertEquals("https://www.facebook.com/some_fake_user_name_52432562135863", socials.getFb());
		assertEquals("https://instagram.com/some_fake_user_name_52432562135863", socials.getIg());
	}
}