package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.PageCreationPage;

public class AdminEditProtectedPage_GetsWarningTest extends BaseTest {

	@Test
	public void adminEditProtectedPage_GetsWarning() {
		PageCreationPage editPage = loginAsAdmin()
				.searchExisting("Selenium WebDriver")
				.edit();
		
		assertEquals("Warning: This page has been protected so that only users with administrator privileges can edit it. The latest log entry is provided below for reference:", editPage.getWarning());
	}
	
}