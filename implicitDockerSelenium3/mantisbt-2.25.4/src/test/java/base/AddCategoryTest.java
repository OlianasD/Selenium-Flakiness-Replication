package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProjectPage;

public class AddCategoryTest extends BaseTest {

	@Test
	public void addCategory() {
		String projectName = "Project001";
		String categoryName = "Category001";
		EditProjectPage editProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.enterCategory(categoryName)
				.addCategory();
		assertEquals(categoryName, editProj.getProjectCategory());
		editProj.logout();
	}
	
}