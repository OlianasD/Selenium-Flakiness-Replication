package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;
import utils.Strings;

public class UpdateIssueStatusAssignedTest extends BaseTest {

	@Test
	public void updateIssueStatusAssigned() {
		
		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setStatus(Strings.statusAssigned)
				.updateIssue();
		
		assertEquals(Strings.statusAssigned, issueDetails.getStatus());
		issueDetails.logout();
	}
	
}