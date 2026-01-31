package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssueDetailsPage;
import utils.Strings;

public class UpdateIssueSeverityTest extends BaseTest {

	@Test
	public void updateIssueSeverity() {
		
		ViewIssueDetailsPage issueDetails = new BaseNavBar(driver)
				.viewIssues()
				.editFirstIssue()
				.setSeverity(Strings.majorSeverity)
				.updateIssue();
		
		assertEquals(Strings.majorSeverity, issueDetails.getSeverity());
		issueDetails.logout();
	}
	
}