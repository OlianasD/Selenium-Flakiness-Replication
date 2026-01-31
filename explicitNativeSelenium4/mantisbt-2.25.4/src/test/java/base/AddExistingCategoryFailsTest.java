package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProjectPage;
import utils.Strings;

public class AddExistingCategoryFailsTest extends BaseTest {

	@Test
	public void addExistingCategoryFails() {
		String projectName = "Project001";
		String categoryName = "Category001";
		
		EditProjectPage editProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.enterCategory(categoryName)
				.addCategory();
		
		assertEquals(Strings.existingCategoryError, editProj.getError());
	}
	
}