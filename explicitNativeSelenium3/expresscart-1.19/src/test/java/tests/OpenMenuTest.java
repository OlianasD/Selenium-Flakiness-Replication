package tests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.Home;
import po.SearchResultsPage;



public class OpenMenuTest extends BaseTest {



	@Test
	public void testExpressCartOpenMenu() throws Exception {
		goToHome();
		SearchResultsPage testMenu = new Home(driver).goToTestMenu();
		assertEquals("tag000", testMenu.getSearchKey());
		assertEquals("NewProduct000", testMenu.getFirstItemName());
	}



}
