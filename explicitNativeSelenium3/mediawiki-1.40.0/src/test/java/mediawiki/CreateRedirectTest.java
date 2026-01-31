package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.WikiPage;

public class CreateRedirectTest extends BaseTest {

	@Test
	public void createRedirect() {
		WikiPage page = loginAsAdmin()
			.searchNonExisting("Testing")
			.createNonExisting()
			.closePopups()
			.createSource()
			.setSourceText("#REDIRECT [[Software testing]]")
			.saveSource();
		
		assertEquals("Software testing", page.getMainRedirect());
	}
	
}