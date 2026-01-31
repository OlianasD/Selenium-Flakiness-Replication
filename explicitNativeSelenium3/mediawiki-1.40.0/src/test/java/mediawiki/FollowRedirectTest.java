package mediawiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.WikiPage;

public class FollowRedirectTest extends BaseTest {

	@Test
	public void followRedirect() {
		WikiPage page = loginAsAdmin()
				.searchExisting("Testing");

		assertTrue(page.waitFotTitleToBe("Software testing"));
		assertEquals("(Redirected from Testing)", page.getSourceRedirect());
	}
	
}