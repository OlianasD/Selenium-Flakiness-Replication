package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.WikiPage;

public class FollowRedirectTest extends BaseTest {

	@Test
	public void followRedirect() {
		WikiPage page = loginAsAdmin()
				.searchExisting("Testing");
		
		assertEquals("Software testing", page.getTitle());
		assertEquals("(Redirected from Testing)", page.getSourceRedirect());
	}
	
}