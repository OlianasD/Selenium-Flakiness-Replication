package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.WikiPage;

public class EditPageTest extends BaseTest {

	@Test
	public void editPage() {
		WikiPage page = loginAsAdmin()
			.searchExisting("Software testing")
			.edit()
			.editText(" Testing is performed by running test cases against the system under test (SUT) and collecting their results.")
			.save()
			.setChangeDescription("Page expanded")
			.confirmSave();
		assertEquals(page.getTitle(), "Software testing");
		assertEquals(page.getBody(), "According to the IEEE/ANSI 1059 definition, software testing is the process of analyzing a software item to detect the differences between existing and required conditions (that is defects/errors/bugs) and to evaluate the features of the software item. Testing is performed by running test cases against the system under test (SUT) and collecting their results.");

		
	}
	
}