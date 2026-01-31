package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageUsersPage;
import utils.Strings;

public class AddMultipleUsersTest extends BaseTest {

	@Test
	public void addMultipleUsers() {
		String username = "username00%d";
		String realname = "username00%d";
		String email = "username00%d@username.it";
		
		
		ManageUsersPage usersPage = new BaseNavBar(driver)
				.manage()
				.manageUsers();
		
		for(int i=1; i<=3; i++) {
			usersPage = usersPage
				.createNewUser()
				.setUsername(String.format(username, i))
				.setRealname(String.format(realname, i))
				.setEmail(String.format(email, i))
				.setAccessLevel(Strings.updater)
				.createUser();
			
			assertEquals(String.format(username, i), usersPage.getUsername(i+1));
			assertEquals(String.format(realname, i), usersPage.getRealName(i+1));
			assertEquals(String.format(email, i), usersPage.getEmail(i+1));
			assertEquals(Strings.updater, usersPage.getAccessLevel(i+1));
				
		}
	}
	
}