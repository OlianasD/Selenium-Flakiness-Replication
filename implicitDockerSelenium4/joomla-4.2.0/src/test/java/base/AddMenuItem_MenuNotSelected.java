package base;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import po.CreateMenuItemPage;

public class AddMenuItem_MenuNotSelected extends BaseTest {
	
	@Test
	public void addMenuItem_MenuNotSelected() {
		
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
			.selectArchivedArticleType()
			.saveError();
		
		assertEquals("One of the options must be selected", menuItems.getMenuNotSelectedAlert());
	}
}
