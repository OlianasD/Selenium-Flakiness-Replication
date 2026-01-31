package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ChangeCredentialsPage;

public class ChangePassword_TooShortTest extends BaseTest {

	@Test
	public void changePassword_TooShort() {
		ChangeCredentialsPage psw = loginAsUser()
			.specialPages()
			.changeCredentials()
			.clickUsername()
			.setPassword("vznb")
			.confirmPassword("vznb")
			.change();
		
		assertEquals("Passwords must be at least 10 characters.", psw.getErrorMessage());
		
	}
	
}