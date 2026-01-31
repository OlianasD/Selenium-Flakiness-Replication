package base;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.ManageUsersPage;

public class AssignUserToGroup extends BaseTest {
	
	@Test
	public void assignUserToGroup() {
		String group = "Test Group 000";
		String user = "Test User";
		ManageUsersPage users = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.users()
			.editUser(user)
			.assignedGroups()
			.checkGroup(10)
			.saveAndClose();
		
		assertTrue(users.containsGroup(2, group));
		users.logout();
	}
}
