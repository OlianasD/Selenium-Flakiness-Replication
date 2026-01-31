package mediawiki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.ChangeCredentialsPage;

public class ChangePassword_OKTest extends BaseTest {

	@Test
	public void changePassword_OK() {
		ChangeCredentialsPage psw = loginAsUser()
			.specialPages()
			.changeCredentials()
			.clickUsername()
			.setPassword("NewPassword001")
			.confirmPassword("NewPassword001")
			.change();
		
		assertTrue(psw.waitForSuccessMessageToBe("Your credentials have been changed."));
		
	}
	
}