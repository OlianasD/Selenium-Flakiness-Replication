package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.PageProtectPage;

public class ProtectPageTest extends BaseTest {

	@Test
	public void protectPage() {
		PageProtectPage protection = loginAsAdmin()
			.searchExisting("Selenium WebDriver")
			.protect()
			.selectProtectionLevel()
			.confirm()
			.goHome(app_url)
			.searchExisting("Selenium WebDriver")
			.changeProtectionLevel();
		
		assertEquals("Allow only administrators", protection.getProtectionLevel());
	}
	
}