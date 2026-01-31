package base;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import po.ManageGroupsPage;

public class DeleteUserGroup extends BaseTest {
	
	@Test
	public void deleteUserGroup() {
		String group = "Test Group 000";
		ManageGroupsPage groups = loginAsAdmin()
				.siteAdmin()
				.setUsername("administrator")
				.setPassword("dodicicaratteri")
				.login()
				.sideUsers()
				.groups()
				.selectIthGroup(10)
				.deleteGroup();
		
		assertTrue(!groups.isGroupPresent(group));
		groups.logout();
	}
}