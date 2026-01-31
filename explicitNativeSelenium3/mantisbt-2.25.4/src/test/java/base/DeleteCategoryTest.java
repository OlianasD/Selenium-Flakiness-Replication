package base;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProjectPage;

public class DeleteCategoryTest extends BaseTest {

	@Test
	public void deleteCategory() {
		String projectName = "Project001";
		String category = "Category002";
		
		EditProjectPage editProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.deleteCategory()
				.confirmDeleteCategory();
		
		assertFalse(editProj.containsCategory(category));
				
	}
	
	
}