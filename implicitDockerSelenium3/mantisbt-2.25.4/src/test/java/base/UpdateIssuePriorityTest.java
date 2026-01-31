package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;
import utils.Strings;

public class UpdateIssuePriorityTest extends BaseTest {

	@Test
	public void updateIssuePriority() {
		
		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setPriority(Strings.priorityLow)
				.updateIssue();
		
		assertEquals(Strings.priorityLow, issueDetails.getPriority());
		issueDetails.logout();
	}
	
}