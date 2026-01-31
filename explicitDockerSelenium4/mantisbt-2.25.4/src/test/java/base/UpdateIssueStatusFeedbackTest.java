package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;
import utils.Strings;

public class UpdateIssueStatusFeedbackTest extends BaseTest {

	@Test
	public void updateIssueStatusFeedback() {
		
		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setStatus(Strings.statusFeedback)
				.updateIssue();
		
		assertEquals(Strings.statusFeedback, issueDetails.getStatus());
		issueDetails.logout();
	}
	
}