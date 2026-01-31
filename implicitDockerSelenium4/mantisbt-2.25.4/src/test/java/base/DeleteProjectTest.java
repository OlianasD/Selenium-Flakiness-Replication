package base;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageProjectPage;

public class DeleteProjectTest extends BaseTest {

	@Test
	public void deleteProject() {
		String projectName = "Project001";
		ManageProjectPage manageProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.deleteProject()
				.confirmDelete();
		assertFalse(manageProj.isProjectPresent(projectName));
		manageProj.logout();
	}
	
}