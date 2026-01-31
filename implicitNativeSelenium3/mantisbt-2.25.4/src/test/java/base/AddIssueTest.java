package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ViewIssuesPage;
import utils.Strings;

public class AddIssueTest extends BaseTest {

	@Test
	public void addIssue() {
		String category = "Category001";
		
		String severity = "crash";
		
		String summary = "Summary001";
		String description = "description001";
		
		ViewIssuesPage viewIssues = new BaseNavBar(driver)
				.reportIssue()
				.setCategory(category)
				.setReproducibility(Strings.reproducibilityRandom)
				.setSeverity(severity)
				.setPriority(Strings.priorityImmediate)
				.setSummary(summary)
				.setDescription(description)
				.submitIssue()
				.viewIssues();
		assertEquals(category, viewIssues.getCategory());
		assertEquals(severity, viewIssues.getSeverity());
		assertEquals(summary, viewIssues.getSummary());
		viewIssues.logout();
		
	}
	
}