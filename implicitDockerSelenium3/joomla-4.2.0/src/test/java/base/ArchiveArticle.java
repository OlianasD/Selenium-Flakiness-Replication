package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ManageArticlesPage;

public class ArchiveArticle extends BaseTest {
	
	@Test
	public void archiveArticle() {
		ManageArticlesPage articles = loginAsAdmin()
				.siteAdmin()
				.setUsername("administrator")
				.setPassword(rootPassword)
				.login()
				.articles()
				.archiveSecondArticle();
		
		assertEquals("Article archived.", articles.getAlertMessage());
		articles.logout();
	}
}
