package base;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import po.ArchivedArticlesPage;

public class SeeArchivedArticle extends BaseTest {
	
	@Test
	public void seeArchivedArticle() {
		String title = "Your Modules";
		ArchivedArticlesPage arts = loginAsAdmin()
				.home()
				.testMenuItem();
				
		assertTrue(arts.containsArticle(title));
		arts.adminLogout();
		
	}
}
