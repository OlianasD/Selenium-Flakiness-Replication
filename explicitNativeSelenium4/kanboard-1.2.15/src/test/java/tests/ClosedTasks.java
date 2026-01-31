package tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.LoginPage;
import po.SearchResultsPage;

public class ClosedTasks extends BaseTest {



		  
	@Test
	public void searchClosedTask() {
		SearchResultsPage results = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.search("status:closed");
		
		assertEquals("task 3", results.getFirstTask());
			  
	}
		  

		  
}
