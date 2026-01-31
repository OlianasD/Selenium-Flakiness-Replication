package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ChangeCredentialsPage;

public class ChangePassword_OKTest extends BaseTest {

	@Test
	public void changePassword_OK() {
		ChangeCredentialsPage psw = loginAsUser()
			.specialPages()
			.changeCredentials()
			.clickUsername()
			.setPassword("e2eW3Bt3s71nGB3nchM4rK_1")
			.confirmPassword("e2eW3Bt3s71nGB3nchM4rK_1")
			.change();
		
		assertEquals("Your credentials have been changed.", psw.getSuccessMessage());
		
	}
	
}