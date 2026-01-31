package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.RevisionHistoryPage;
import po.WikiPage;

public class RevertLastCommitTest extends BaseTest {

	@Test
	public void revertLastCommit() {
		RevisionHistoryPage history = loginAsAdmin()
			.searchExisting("Selenium WebDriver")
			.viewHistory()
			.rollbackLastEdit();
		
		assertEquals("Reverted edits by User001 (talk | contribs | block); changed back to last revision by Admin (talk | contribs | block).", history.getMessage());
		WikiPage page = history.goToLink("Selenium WebDriver");
		
		assertEquals(page.getTitle(), "Selenium WebDriver");
		assertEquals(page.getBody(), "Developer: Selenium Latest version: 3.141.59Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language (Selenium IDE).");
	}
	
}