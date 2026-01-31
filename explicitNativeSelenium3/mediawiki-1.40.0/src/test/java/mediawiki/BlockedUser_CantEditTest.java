package mediawiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.PageCreationPage;

public class BlockedUser_CantEditTest extends BaseTest {

	@Test
	public void blockedUser_CantEdit() {
		PageCreationPage editPage = loginAsUser()
			.goToUserPage("User001")
			.edit();
		
		assertEquals("You do not have permission to edit this page, for the following reason:", editPage.getWarning());
		assertTrue(editPage.getPermissionErrors().contains("Your username or IP address has been blocked"));
	}
	
}