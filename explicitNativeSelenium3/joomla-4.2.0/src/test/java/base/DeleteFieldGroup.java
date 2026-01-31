package base;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import po.ManageFieldGroupsPage;

public class DeleteFieldGroup extends BaseTest {
	
	@Test
	public void deleteFieldGroup() {
		String group = "Test Group 000";
		ManageFieldGroupsPage groups = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword("dodicicaratteri")
			.login()
			.sideContent()
			.fieldGroups()
			.selectIthFieldGroup(1)
			.deleteSelectedGroup();
		
		assertTrue(!groups.isGroupPresentAtFirstRow(group));
		groups.logout();
	}
}