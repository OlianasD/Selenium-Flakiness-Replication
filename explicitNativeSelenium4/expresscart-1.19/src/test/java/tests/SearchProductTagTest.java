package tests;



import static org.junit.Assert.*;

import org.junit.Test;

import po.Home;
import po.SearchResultsPage;


public class SearchProductTagTest extends BaseTest {



	@Test
	public void testExpressCartSearchProductTag() throws Exception {
		goToHome();
		SearchResultsPage results = new Home(driver).setSearchText("tag000").doSearch();
		assertEquals("NewProduct000", results.getFirstItemName());
		
	}



}
