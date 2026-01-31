package tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.LoginPage;
import po.TaskPage;

public class ChangeTask extends BaseTest{
		  
	@Test
	public void changeTask() {
		TaskPage task = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.goToProject("Test 2")
				.goToTask("task 3")
				.closeTask()
				.confirmCloseTask();
		
		assertEquals("closed", task.getStatus("closed"));
			  
	}
		  

		  
}
