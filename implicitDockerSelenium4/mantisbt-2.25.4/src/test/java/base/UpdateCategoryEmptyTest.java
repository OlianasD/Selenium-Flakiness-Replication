package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProjectPage;
import utils.Strings;

public class UpdateCategoryEmptyTest extends BaseTest {

	@Test
	public void updateCategoryEmpty() {
		String projectName = "Project001";
		
		EditProjectPage editProj = new BaseNavBar(driver)
				.manage()
				.manageProjects()
				.goToProject(projectName)
				.editCategory()
				.setCategoryName("")
				.updateCategory();
		
		assertEquals(Strings.emptyCategoryError, editProj.getError());
		editProj.logout();
	}
	
}