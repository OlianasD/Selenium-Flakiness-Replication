package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.LanguagePage;

public class ChangeLanguageTest extends BaseTest {
	
	@Test
	public void changeLanguage() {
		LanguagePage lang = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.general()
			.language()
			.setLanguage("Italiano (Italia)")
			.save();
		
		assertEquals("Italiano (Italia)", lang.getLanguage());
		lang = lang.setLanguage("English").save();
		assertEquals("English", lang.getLanguage());
	}
	
}