package base;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProjectPage;

public class LinkMultipleSubprojectsTest extends BaseTest {

	@Test
	public void linkMultipleSubprojects() {
		String projectName = "Project001";
		EditProjectPage project = new BaseNavBar(driver)
			.manage()
			.manageProjects()
			.goToProject(projectName)
			.selectSubproject("testSubProject1")
			.linkSubproject();
		
		assertTrue(project.isSubprojectPresent("testSubProject1"));
		
		project = project
				.selectSubproject("testSubProject2")
				.linkSubproject();
		
		assertTrue(project.isSubprojectPresent("testSubProject2"));
	}
	
}