package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.CreateGroupPage;

public class AddEmptyGroup extends BaseTest {
	
	@Test
	public void addEmptyGroup() {
		
		CreateGroupPage groups = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword("dodicicaratteri")
			.login()
			.sideUsers()
			.groups()
			.createGroup()
			.saveError();
		
		assertEquals("Please fill in this field", groups.getEmptyTitleAlert());
	}
}