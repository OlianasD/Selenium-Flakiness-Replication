package base;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageProjectPage;
import utils.Strings;

public class AddMultipleSubprojectsTest extends BaseTest {

	@Test
	public void addMultipleSubprojects() {
		String projectName = "Project001";
		String status = "release";
		String description = "Description";
		
		ManageProjectPage manageProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.createProject()
				.setName(projectName)
				.setStatus(status)
				.setVisibility(Strings.visibilityPublic)
				.setDescription(description)
				.createProject()
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.createSubproject()
				.setName("testSubProject1")
				.createSubproject();
		
		assertTrue(manageProj.isProjectPresent("testSubProject1"));
		
		manageProj = manageProj
				.goToProject(projectName)
				.createSubproject()
				.setName("testSubProject2")
				.createSubproject();
		
		assertTrue(manageProj.isProjectPresent("testSubProject2"));
		
	}
	
}