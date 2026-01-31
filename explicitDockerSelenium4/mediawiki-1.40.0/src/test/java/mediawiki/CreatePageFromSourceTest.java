package mediawiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.WikiPage;

public class CreatePageFromSourceTest extends BaseTest {

	@Test
	public void createPageFromSource() {
		WikiPage page = loginAsAdmin()
				.searchNonExisting("Selenium WebDriver")
				.createNonExisting()
				.closePopups()
				.createSource()
				.setSourceText("Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language (Selenium IDE).")
				.saveSource();

		assertTrue(page.waitFotTitleToBe("Selenium WebDriver"));
		assertEquals(page.getBody("Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language (Selenium IDE)."), 
				"Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language (Selenium IDE).");	
	}
	
}