package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;

public class UpdateIssueSummaryTest extends BaseTest {

	@Test
	public void updateIssueSummary() {
		String summary = "Summary002";
		
		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setSummary(summary)
				.updateIssue();
		
		assertEquals("0000001: "+summary, issueDetails.getSummary());
		issueDetails.logout();
	}
	

	
}