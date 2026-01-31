package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.NewUserPage;

public class AddLocalUser_EmptyUsername extends BaseTest {
	
	@Test()
	public void addEmptyUser() {
		NewUserPage user = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.usersManagement()
				.newUser()
				.setFullname("User2")
				.setEmail("user2@gmail.com")
				.setPassword("test123")
				.confirmPassword("test123")
				.saveError();
		
		assertEquals("The username is required", user.getNameError());
			  
	}
	
}
