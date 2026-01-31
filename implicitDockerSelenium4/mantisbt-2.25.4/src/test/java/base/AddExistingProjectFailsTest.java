package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.CreateProjectPage;
import utils.Strings;

public class AddExistingProjectFailsTest extends BaseTest {

	@Test
	public void addExistingProjectFails() {
		String projectName = "Project001";
		String status = "release";
		String description = "Description";
		
		
		CreateProjectPage project = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.createProject()
				.setName(projectName)
				.setStatus(status)
				.setVisibility(Strings.visibilityPublic)
				.setDescription(description)
				.createProjectFails();
		
		assertEquals(Strings.existingProjectError, project.getError());
				
	}
	
	
}