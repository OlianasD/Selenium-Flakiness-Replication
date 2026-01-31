package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.LoginPage;
import po.ProjectSummaryPage;


public class AddNewPrivateProject extends BaseTest {
		
		  
	@Test
	public void addNewPrivateProject() {
		ProjectSummaryPage project = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.newPersonalProject()
				.addNewProject("Test private 2");
			  
		assertEquals("Test private 2", project.getTitle());
		assertEquals("This project is open", project.getStatus());
		assertTrue(project.getAccessLevel().contains("This project is personal"));
		assertEquals("Public access disabled", project.getPublicAccess());
			  
	}
		  
		  
		  
}
