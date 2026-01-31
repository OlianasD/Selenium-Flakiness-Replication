package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.NewUserPage;

public class AddLocalUser_EmptyConfirmPassword extends BaseTest {
	
	@Test()
	public void addEmptyConfirmation() {
		NewUserPage user = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.usersManagement()
				.newUser()
				.setUsername("TestUser2")
				.setFullname("User2")
				.setEmail("user2@gmail.com")
				.setPassword("test123")
				.saveError();
		
		assertEquals("The confirmation is required", user.getPswConfirmError());
			  
	}
	
}
