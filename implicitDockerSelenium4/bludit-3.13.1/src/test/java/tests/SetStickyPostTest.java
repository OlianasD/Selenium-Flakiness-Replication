package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import po.AdminLogin;
import po.StickyPage;

public class SetStickyPostTest extends BaseTest {
	
	@Test
	public void setStickyPost() {
		StickyPage sticky = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.content()
			.editThirdContent()
			.options()
			.advanced()
			.setPostType("Sticky")
			.options()
			.saveAndStay()
			.content()
			.sticky();
		assertEquals("Set up your new site", sticky.getFirstStickyTitle());
	}
	
}
