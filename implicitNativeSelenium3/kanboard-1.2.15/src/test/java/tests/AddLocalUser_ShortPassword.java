package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.NewUserPage;

public class AddLocalUser_ShortPassword extends BaseTest {
	
	@Test()
	public void addShortPassword() {
		NewUserPage user = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.usersManagement()
				.newUser()
				.setUsername("TestUser2")
				.setFullname("User2")
				.setEmail("user2@gmail.com")
				.setPassword("test")
				.confirmPassword("test")
				.saveError();
		
		assertEquals("The minimum length is 6 characters", user.getPswError());
			  
	}
	
}
