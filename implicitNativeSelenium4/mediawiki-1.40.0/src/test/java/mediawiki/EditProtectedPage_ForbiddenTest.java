package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.PageCreationPage;

public class EditProtectedPage_ForbiddenTest extends BaseTest {

	@Test
	public void editProtectedPage_Forbidden() {
		PageCreationPage editPage = loginAsUser()
				.searchExisting("Selenium WebDriver")
				.forceEdit()
				.closeInitialPopup();
		
		assertEquals("You do not have permission to edit this page, for the following reason:", editPage.getWarning());
		assertEquals("This page has been protected to prevent editing or other actions.", editPage.getPermissionErrors());
	}
	
}