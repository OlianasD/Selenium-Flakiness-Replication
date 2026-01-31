package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssuesPage;
import utils.Strings;

public class AssignIssueTest extends BaseTest {

	@Test
	public void assignIssue() {
		ViewIssuesPage viewIssues = new BaseNavBar(driver)
				.viewIssues()
				.selectFirstIssue()
				.assignIssue()
				.confirmAssignment();
		assertEquals(Strings.assignedAdministrator, viewIssues.getStatus());
		viewIssues.logout();
	}
	
}