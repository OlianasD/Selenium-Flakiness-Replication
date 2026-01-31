package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ManageGroupsPage;

public class AddGroup extends BaseTest {
	
	@Test
	public void addGroup() {
		String group = "Test Group 000";
		ManageGroupsPage groups = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.sideUsers()
			.groups()
			.createGroup()
			.setTitle(group)
			.saveAndClose();
		assertEquals(group, groups.getIthGroupName(10));
		groups.logout();
	}
}