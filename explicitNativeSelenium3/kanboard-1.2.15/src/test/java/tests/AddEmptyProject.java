package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AddNewProjectPage;
import po.LoginPage;


public class AddEmptyProject extends BaseTest {
	
	@Test()
	public void addEmptyProject() {
		AddNewProjectPage newProjPage = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.newProject()
				.addEmptyProject();
			  
		assertEquals("The project name is required", newProjPage.getErrorMessage());

			  
	}
}
