package base;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import po.ManageFieldsPage;


public class AssignFieldToGroup extends BaseTest {
	
	@Test
	public void assignFieldToGroup() {
		String field = "Test Field 000";
		String group = "Test Group 000";
		ManageFieldsPage fields = loginAsAdmin()
				.siteAdmin()
				.setUsername("administrator")
				.setPassword("dodicicaratteri")
				.login()
				.sideContent()
				.fields()
				.goToField(field)
				.selectGroup(group)
				.saveAndClose();
		
		assertTrue(fields.fieldHasGroup(1, group));
		fields.logout();
	}
}
