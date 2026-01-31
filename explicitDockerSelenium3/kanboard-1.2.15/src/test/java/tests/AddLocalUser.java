package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.UserSummaryPage;




public class AddLocalUser extends BaseTest {

		
	@Test()
	public void addLocalUser() {
		UserSummaryPage user = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.usersManagement()
				.newUser()
				.setUsername("TestUser")
				.setFullname("User1")
				.setEmail("user@gmail.com")
				.setPassword("test123")
				.confirmPassword("test123")
				.save();
		
		assertEquals(user.getUsername(), "TestUser");
		assertEquals(user.getFullname(), "User1");
		assertEquals(user.getEmail(), "user@gmail.com");
			  
	}
		  

		  
		  
		  
}
