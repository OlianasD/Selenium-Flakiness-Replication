package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLogin;
import po.SiteCategoryPage;

public class SeeCategoryArticlesTest extends BaseTest {
	@Test
	public void seeCategoryArticles() {
		SiteCategoryPage catArticles = new AdminLogin(driver)
			.setUsername(username)
			.setPassword(password)
			.login()
			.categories()
			.seeCategoryArticles("aaanewurl001");
		
		assertEquals("Create your own content", catArticles.getFirstArticle());
	}
}