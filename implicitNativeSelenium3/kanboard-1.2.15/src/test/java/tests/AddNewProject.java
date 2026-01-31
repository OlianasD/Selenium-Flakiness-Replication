package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import po.LoginPage;
import po.ProjectSummaryPage;




public class AddNewProject extends BaseTest {

		  
	@Test()
	public void addNewProject() {
		ProjectSummaryPage project = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.newProject()
				.addNewProject("Test 2");
			  
		assertEquals("Test 2", project.getTitle());
		assertEquals("This project is open", project.getStatus());

			  
	}
		  

		  
		  
}
