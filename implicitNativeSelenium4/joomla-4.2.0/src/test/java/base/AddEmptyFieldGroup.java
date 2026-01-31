package base;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import po.CreateFieldGroupPage;

public class AddEmptyFieldGroup extends BaseTest {
	
	@Test
	public void addEmptyFieldGroup() {
		
		CreateFieldGroupPage groups = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword("dodicicaratteri")
			.login()
			.sideContent()
			.fieldGroups()
			.createGroup()
			.saveError();
		
		assertEquals("Please fill in this field", groups.getEmptyTitleAlert());
	}
}