package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.WikiPage;

public class CreateUserPageTest extends BaseTest {

	@Test
	public void createUserPage() {
		WikiPage page = loginAsUser()
				.goToUserPage("User001")
				.createSource()
				.setSourceText("This is my user page")
				.saveSource();
		
		assertEquals(page.getTitle(), "User:User001");
		assertEquals(page.getBody(), "This is my user page");
	}
	
	
}