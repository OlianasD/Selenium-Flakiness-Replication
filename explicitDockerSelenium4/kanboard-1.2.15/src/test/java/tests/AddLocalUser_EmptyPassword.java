package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.NewUserPage;

public class AddLocalUser_EmptyPassword extends BaseTest {
	
	@Test()
	public void addEmptyPassword() {
		NewUserPage user = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.usersManagement()
				.newUser()
				.setUsername("TestUser2")
				.setFullname("User2")
				.setEmail("user2@gmail.com")
				.saveError();
		
		assertEquals("The password is required", user.getPswError());
			  
	}
	
}
