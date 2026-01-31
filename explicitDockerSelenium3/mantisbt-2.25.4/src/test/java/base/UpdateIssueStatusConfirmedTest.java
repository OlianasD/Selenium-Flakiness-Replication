package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;
import utils.Strings;

public class UpdateIssueStatusConfirmedTest extends BaseTest {

	@Test
	public void updateIssueStatusConfirmed() {

		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setStatus(Strings.statusConfirmed)
				.updateIssue();
		
		assertEquals(Strings.statusConfirmed, issueDetails.getStatus());
		issueDetails.logout();
	}
	
}