package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.WikiPage;

public class CreateAndLinkPageTest extends BaseTest {

	@Test
	public void createAndLinkPage() {
		WikiPage page = loginAsAdmin()
				.searchNonExisting("E2E Web Testing")
				.createNonExisting()
				.closePopups()
				.setText("End-to-End (E2E) testing is a  ")
				.addLink("Software testing")
				.setText(" technique that aims to test a system as a whole, as a human tester would")
				.save()
				.setChangeDescription("Page created")
				.confirmSave();
		
		assertEquals(page.getTitle(), "E2E Web Testing");
		page.goToLink("Software testing");
		assertEquals(page.getTitle(), "Software testing");
		assertEquals(page.getBody(), "According to the IEEE/ANSI 1059 definition, software testing is the process of analyzing a software item to detect the differences between existing and required conditions (that is defects/errors/bugs) and to evaluate the features of the software item.");
	}
	
}