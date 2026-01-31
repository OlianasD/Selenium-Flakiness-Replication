package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.LoginPage;
import po.UsersManagementPage;




public class RemoveUser extends BaseTest {

		  
	@Test
	public void removeUser() {
		UsersManagementPage users = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.usersManagement()
				.removeFirstUser();
		
		assertTrue(users.firstUserIsNot("remote1"));
			  
	}
		  

}
