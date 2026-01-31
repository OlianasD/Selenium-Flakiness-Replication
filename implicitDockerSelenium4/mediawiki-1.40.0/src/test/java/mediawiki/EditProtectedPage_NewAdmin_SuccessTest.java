package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.WikiPage;

public class EditProtectedPage_NewAdmin_SuccessTest extends BaseTest {

	@Test
	public void editProtectedPage_NewAdmin_Success() {
		WikiPage page = loginAsUser()
			.searchExisting("Selenium WebDriver")
			.edit()
			.editText(" Selenium WebDriver accepts commands (sent in Selenese, or via a Client API) and sends them to a browser.")
			.save()
			.setChangeDescription("Page expanded")
			.confirmSave();
		assertEquals(page.getTitle(), "Selenium WebDriver");
		assertEquals(page.getBody(), "Developer: Selenium Latest version: 3.141.59Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language (Selenium IDE). Selenium WebDriver accepts commands (sent in Selenese, or via a Client API) and sends them to a browser.");
	}
	
}