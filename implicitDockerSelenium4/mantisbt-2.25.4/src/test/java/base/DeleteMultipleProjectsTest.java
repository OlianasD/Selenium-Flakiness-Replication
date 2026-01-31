package base;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageProjectPage;

public class DeleteMultipleProjectsTest extends BaseTest {

	@Test
	public void deleteMultipleProjects() {
		String[] projects = {"Project001", "testSubProject1", "testSubProject2"};
		ManageProjectPage manageProj = new BaseNavBar(driver)
				.manage()
				.manageProjects();
		
		for(int i=0; i<3; i++) {
			manageProj = manageProj.goToProject(projects[i])
				.deleteProject()
				.confirmDelete();
			assertFalse(manageProj.isProjectPresent(projects[i]));
		}
	}

}
