package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AuthorLoginPage;
import po.BaseNavBar;

public class EmptyLogin extends BaseTest {
	
	@Test
	public void emptyLogin() {
		AuthorLoginPage login = new BaseNavBar(driver)
				.authorLogin()
				.badLogin();
		
		assertEquals("Please fill in this field", login.getEmptyLoginAlert());
	}
}