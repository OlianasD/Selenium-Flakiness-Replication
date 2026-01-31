package mediawiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.RevisionHistoryPage;
import po.WikiPage;

public class RevertLastCommitTest extends BaseTest {

	@Test
	public void revertLastCommit() throws InterruptedException {
		RevisionHistoryPage history = loginAsAdmin()
			.searchExisting("Selenium WebDriver")
			.viewHistory()
			.rollbackLastEdit();
		
		assertTrue(history.waitForMessageToBe("Reverted edits by User001 (talk | contribs | block); changed back to last revision by Admin (talk | contribs | block)."));
		//Thread.sleep(1000);
		WikiPage page = history.goToLink("Selenium WebDriver");
		assertTrue(page.waitForTitleToBe("Selenium WebDriver"));
		assertEquals(page.getBody("Developer: Selenium Latest version: 3.141.59Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language (Selenium IDE)."),
				"Developer: Selenium Latest version: 3.141.59Selenium is an open source umbrella project for a range of tools and libraries aimed at supporting browser automation. It provides a playback tool for authoring functional tests across most modern web browsers, without the need to learn a test scripting language (Selenium IDE).");
	}
	
}