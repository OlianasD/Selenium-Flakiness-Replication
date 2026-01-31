package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProjectPage;

public class UpdateCategoryTest extends BaseTest {

	@Test
	public void updateCategory() {
		String projectName = "Project001";
		String category = "Category002";
		
		EditProjectPage editProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.editCategory()
				.setCategoryName(category)
				.updateCategory();
		assertEquals(category, editProj.getProjectCategory());
		editProj.logout();
	}
	
}