package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.ProjectManagementPage;




public class AddNewTask extends BaseTest {

		  
	@Test()
	public void addNewTask() {
		ProjectManagementPage project = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.goToFirstProject()
				.newTask()
				.setNewTaskName("task 3")
				.saveNewTask();
		assertEquals("task 3", project.getFirstTaskName());
		  
	}
		  

		  
		  
}
