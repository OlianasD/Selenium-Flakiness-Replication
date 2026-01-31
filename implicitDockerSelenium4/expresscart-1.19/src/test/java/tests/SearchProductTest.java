package tests;


import po.Home;
import po.SearchResultsPage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class SearchProductTest extends BaseTest {



	@Test
	public void testExpressCartSearchProduct() throws Exception {
		goToHome();
		SearchResultsPage res = new Home(driver)
				.setSearchText("NewProduct000")
				.doSearch();
		
		assertEquals("NewProduct000", res.getSearchKey());
		assertEquals("NewProduct000", res.getFirstItemName());
	}



}
