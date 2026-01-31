package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;
import utils.Strings;

public class UpdateIssueStatusAcknowledgedTest extends BaseTest {

	@Test
	public void updateIssueStatusAcknowledged() {

		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setStatus(Strings.statusAcknowledged)
				.updateIssue();
		
		assertEquals(Strings.statusAcknowledged, issueDetails.getStatus());
		issueDetails.logout();
	}
	
}