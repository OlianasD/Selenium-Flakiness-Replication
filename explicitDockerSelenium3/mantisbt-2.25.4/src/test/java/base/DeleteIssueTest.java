package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssuesPage;
import utils.Strings;

public class DeleteIssueTest extends BaseTest {

	@Test
	public void deleteIssue() {
		ViewIssuesPage viewIssues = new BaseNavBar(driver)
				.viewIssues()
				.selectFirstIssue()
				.deleteIssue()
				.deleteIssue();
		
		assertEquals(Strings.anomaliesEmpty, viewIssues.getIssueListText());
		viewIssues.logout();
	}
	
}