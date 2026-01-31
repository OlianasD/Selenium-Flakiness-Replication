package mediawiki;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.UserRightsPage;

public class PromoteToAdminTest extends BaseTest {

	@Test
	public void promoteToAdmin() {
		UserRightsPage rights = loginAsAdmin()
				.specialPages()
				.userRights()
				.findUser("User001")
				.checkAdmin()
				.setReason("promotion")
				.save();
		
		assertTrue(rights.isAdminChecked());
		assertTrue(rights.getLogEntry().contains("changed group membership for User001 from (none) to administrator (promotion)"));
	}
	
}