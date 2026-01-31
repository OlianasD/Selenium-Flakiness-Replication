package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageProjectPage;
import utils.Strings;

public class AddProjectTest extends BaseTest {

	@Test
	public void addProject() {
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
				.manageProjects();
		assertEquals(projectName, manageProj.getProjectName());
		assertEquals(status, manageProj.getProjectStatus());
		assertEquals(Strings.visibilityPublic, manageProj.getProjectVisibility());
		assertEquals(description, manageProj.getProjectDescription());
		manageProj.logout();
				
	}
	
}