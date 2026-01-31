package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;
import utils.Strings;

public class UpdateIssueStatusResolvedTest extends BaseTest {

	@Test
	public void updateIssueStatusResolved() {
		
		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setStatus(Strings.statusResolved)
				.updateIssue();
		
		assertEquals(Strings.statusResolved, issueDetails.getStatus());
		issueDetails.logout();
	}
	
}