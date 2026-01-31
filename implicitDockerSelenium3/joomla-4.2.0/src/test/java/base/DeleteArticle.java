package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import po.ManageArticlesPage;

public class DeleteArticle extends BaseTest {
	
	@Test
	public void deleteArticle() {
		String title = "Test Article 01";
		String expectedAlert = "Article trashed.";
		
		ManageArticlesPage articles = loginAsAdmin()
				.siteAdmin()
				.setUsername("administrator")
				.setPassword(rootPassword)
				.login()
				.articles()
				.deleteFirstArticle();
		
		assertEquals(expectedAlert, articles.getAlertMessage());
		assertFalse(articles.containsArticle(title));
		articles.logout();
	}
}
