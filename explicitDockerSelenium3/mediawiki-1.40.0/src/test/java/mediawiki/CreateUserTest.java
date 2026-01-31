package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.CreateAccountPage;

public class CreateUserTest extends BaseTest {

	@Test
	public void createUser() {
		CreateAccountPage account = loginAsAdmin()
				.specialPages()
				.createAccount()
				.setUsername("User001")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.confirmPassword("e2eW3Bt3s71nGB3nchM4rK")
				.setRealName("Real Name 001")
				.create();
		
		assertEquals("The user account for User001 (talk) has been created.", account.getSuccessMessage());
	}
	
}