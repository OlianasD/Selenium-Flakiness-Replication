package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoggedHome;

public class AddNewArticle extends BaseTest {
	
	@Test
	public void addNewArticle() {
		String title = "Test Article 01";
		String body = "This is the body of the first article for testing the platform";
		
		LoggedHome home = loginAsAdmin()
				.createPost()
				.setTitle(title)
				.setBody(body)
				.save();
		
		assertEquals(title, home.getFirstArticleTitle());
		assertEquals(body, home.getFirstArticleBody());
		home.adminLogout();
	}
}
