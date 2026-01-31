package mediawiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.WikiPage;

public class ApplyTemplateTest extends BaseTest {

	@Test
	public void applyTemplate() {
		WikiPage page = loginAsAdmin()
			.searchExisting("Selenium WebDriver")
			.editSource()
			.editStart("{{Software|dev=Selenium|ver=3.141.59}}")
			.saveSource();
		assertTrue(page.waitFotTitleToBe("Selenium WebDriver"));
		assertTrue(page.getBody("Developer: Selenium Latest version: 3.141.59").contains("Developer: Selenium Latest version: 3.141.59"));
	}
	
}