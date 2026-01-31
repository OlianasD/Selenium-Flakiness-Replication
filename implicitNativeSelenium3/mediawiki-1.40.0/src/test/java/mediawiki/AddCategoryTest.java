package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.WikiPage;

public class AddCategoryTest extends BaseTest {

	@Test
	public void addCategory() {
		WikiPage page = loginAsAdmin()
			.searchExisting("Selenium WebDriver")
			.edit()
			.options()
			.categories()
			.addCategory("Browser automation tools")
			.applyChanges()
			.save()
			.setChangeDescription("Added category")
			.confirmSave();
		
		assertEquals(page.getTitle(), "Selenium WebDriver");
		assertEquals(page.getCategory(), "Browser automation tools");
		
	}
	
}