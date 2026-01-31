package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;
import utils.Strings;

public class UpdateIssueStatusNewTest extends BaseTest {

	@Test
	public void updateIssueStatusNew() {
		
		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setStatus(Strings.statusNew)
				.updateIssue();
		
		assertEquals(Strings.statusNew, issueDetails.getStatus());
		issueDetails.logout();
	}
	
}