package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.CreatePostPage;

public class AddEmptyArticle extends BaseTest {
	
	@Test
	public void addEmptyArticle() {

		CreatePostPage post = loginAsAdmin()
				.createPost()
				.saveError();
		
		assertEquals("Please fill in this field", post.getEmptyTitleAlert());
	}
}
