package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.LoginPage;
import po.ProjectListPage;





public class RemoveProject extends BaseTest {

		  
	@Test
	public void removeProject() {
		ProjectListPage projects = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.firstProjectSummary()
				.remove();
		
		assertTrue(projects.firstProjectIsNot("Test 2"));
			  
	}

}
