package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.CreateAccountPage;

public class CreateEmptyUser_Fails extends BaseTest {

	@Test
	public void createEmptyUser_Fails() {
		CreateAccountPage account = loginAsAdmin()
				.specialPages()
				.createAccount()
				.create();
		
		assertEquals("Please fill out this field.", account.getUsernameValidationMessage());
	}
	
}
