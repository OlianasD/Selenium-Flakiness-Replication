package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoggedHome;

public class EditArticle extends BaseTest {
	
	@Test
	public void editArticle() {
		String expectedBody = "This is the body of the first article for testing the platformEDITED";
		
		LoggedHome home = loginAsAdmin()
				.home()
				.editFirstArticle()
				.setBody("EDITED")
				.save();
		
		assertEquals(expectedBody, home.getFirstArticleBody());
		home.adminLogout();
	}
}
