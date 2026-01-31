package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.MainPage;
import po.WikiPage;

public class SearchPageTest extends BaseTest {

	@Test
	public void searchPage() {
		WikiPage page = new MainPage(driver)
				.searchExisting("Software testing");
		
		assertEquals(page.getTitle(), "Software testing");
		assertEquals(page.getBody(), "According to the IEEE/ANSI 1059 definition, software testing is the process of analyzing a software item to detect the differences between existing and required conditions (that is defects/errors/bugs) and to evaluate the features of the software item.");
	}
	
}