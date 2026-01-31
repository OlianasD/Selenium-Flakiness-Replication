package base;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import po.CreateMenuItemPage;

public class AddMenuItem_EmptyMenuType extends BaseTest {
	
	@Test
	public void addMenuItem_EmptyMenuType() {
		String name = "Test menu item";
		CreateMenuItemPage menuItems = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.menus()
			.menuItems()
			.createMenuItem()
			.setTitle(name)
			.selectMenu("Main Menu")
			.saveError();
		
		assertEquals("Please fill in this field", menuItems.getEmptyMenuTypeAlert());
	}
}
