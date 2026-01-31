package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.Home;
import po.SearchResultsPage;



public class SearchDeletedProductTagFailsTest extends BaseTest {


	@Test
	public void testExpressCartSearchDeletedProductTagFails() throws Exception {
		goToHome();
		SearchResultsPage results = new Home(driver).setSearchText("tag000").doSearch();
		assertEquals("No products found", results.getDangerAlertText());
		
	}



}
