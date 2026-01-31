package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ManageArticlesPage;

public class AssignCategory extends BaseTest {
	
	@Test
	public void assignCategory() {
		String article = "Your Template";
		String cat = "Test Category 001";
		ManageArticlesPage articles = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.articles()
			.goToArticle(article)
			.selectCategory(cat)
			.save();
		
		assertEquals(cat, articles.getFirstArticleCategory());
		articles.logout();
	}
}