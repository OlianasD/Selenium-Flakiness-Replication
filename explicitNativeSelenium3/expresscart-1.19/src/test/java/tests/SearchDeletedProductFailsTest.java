package tests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.Home;
import po.SearchResultsPage;

public class SearchDeletedProductFailsTest extends BaseTest {

	@Test
	public void testExpressCartSearchDeletedProductFails() throws Exception {
		goToHome();
		SearchResultsPage results = new Home(driver).setSearchText("NewProduct000").doSearch();
		assertEquals("No products found", results.getDangerAlertText());
		
	}


}
