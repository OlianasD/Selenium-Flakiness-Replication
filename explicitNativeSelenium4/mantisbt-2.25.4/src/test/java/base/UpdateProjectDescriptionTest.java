package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageProjectPage;

public class UpdateProjectDescriptionTest extends BaseTest {

	@Test
	public void updateProjectDescription() {
		String projectName = "Project001";
		String descr = "UpdatedDescription";
		
		ManageProjectPage manageProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.setDescription(descr)
				.updateProject();
		
		assertEquals(descr, manageProj.getProjectDescription());
		manageProj.logout();
	}
	
}