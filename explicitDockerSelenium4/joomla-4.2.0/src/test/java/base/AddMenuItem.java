package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.MenuItemsPage;

public class AddMenuItem extends BaseTest {
	
	@Test
	public void addMenuItem() {
		String name = "Test menu item";
		
		MenuItemsPage menuItems = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.menus()
			.menuItems()
			.createMenuItem()
			.setTitle(name)
			.selectMenu("Main Menu")
			.selectArchivedArticleType()
			.save();
		
		assertEquals("Menu item saved.", menuItems.getAlertMessage());
		assertTrue(menuItems.containsMenuItem(name));
		menuItems.logout();
	}
}
