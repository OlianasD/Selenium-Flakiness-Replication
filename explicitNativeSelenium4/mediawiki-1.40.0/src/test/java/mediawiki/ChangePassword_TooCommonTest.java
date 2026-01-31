package mediawiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.ChangeCredentialsPage;

public class ChangePassword_TooCommonTest extends BaseTest {

	@Test
	public void changePassword_TooCommon() {
		ChangeCredentialsPage psw = loginAsUser()
			.specialPages()
			.changeCredentials()
			.clickUsername()
			.setPassword("password123")
			.confirmPassword("password123")
			.change();
		
		assertTrue(psw.waitForErrorMessageToBe("The password entered is in a list of very commonly used passwords. Please choose a more unique password."));
		
	}
	
}