package mediawiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.WikiPage;

public class CreateTemplateTest extends BaseTest {

	@Test
	public void createTemplate() {
		WikiPage page = loginAsAdmin()
			.searchNonExisting("Template:Software")
			.createNonExisting()
			.setSourceText("Developer: {{{dev}}} Latest version: {{{ver}}}")
			.saveSource();

		assertTrue(page.waitFotTitleToBe("Template:Software"));
		assertEquals(page.getBody("Developer: {{{dev}}} Latest version: {{{ver}}}"), "Developer: {{{dev}}} Latest version: {{{ver}}}");
	}
	
}