package base;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import po.CreateMenuItemPage;

public class AddMenuItem_EmptyTitle extends BaseTest {
	
	@Test
	public void addMenuItem_EmptyTitle() {
		
		CreateMenuItemPage menuItems = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.menus()
			.menuItems()
			.createMenuItem()
			.selectMenu("Main Menu")
			.selectArchivedArticleType()
			.saveError();
		
		assertEquals("Please fill in this field", menuItems.getEmptyTitleAlert());
	}
}
