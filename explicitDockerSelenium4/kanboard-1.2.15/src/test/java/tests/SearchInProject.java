package tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.LoginPage;
import po.SearchResultsPage;

public class SearchInProject extends BaseTest {
		  
	@Test
	public void searchInProject() {
		SearchResultsPage results = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.search("status:open");
		
		assertEquals("task 3", results.getFirstTask());
			  
	}
		  
		  
}
