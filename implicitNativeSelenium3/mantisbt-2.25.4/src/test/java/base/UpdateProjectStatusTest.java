package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageProjectPage;
import utils.Strings;

public class UpdateProjectStatusTest extends BaseTest {

	@Test
	public void updateProjectStatus() {
		String projectName = "Project001";
		
		
		ManageProjectPage manageProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.setProjectStatus(Strings.projectStatusStable)
				.updateProject();
		
		assertEquals(Strings.projectStatusStable, manageProj.getProjectStatus());
		manageProj.logout();
	}
	
}