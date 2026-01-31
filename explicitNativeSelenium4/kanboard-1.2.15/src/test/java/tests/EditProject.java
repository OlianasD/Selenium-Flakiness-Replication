package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import po.LoginPage;
import po.ProjectSummaryPage;




public class EditProject extends BaseTest {


		  
	@Test()
	public void editProject() {
		ProjectSummaryPage project = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.firstProjectSummary()
				.editProject()
				.setDescription("This is the new description")
				.save()
				.summary();
				  
		assertEquals("This is the new description", project.getDescription());
			  
			  
	}
		  

		  
}
