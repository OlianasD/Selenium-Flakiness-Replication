package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageUsersPage;
import utils.Strings;

public class AddUserTest extends BaseTest {

	@Test
	public void addUser() {
		String username = "username001";
		String realname = "username001";
		String email = "username@username.it";
		ManageUsersPage usersPage = new BaseNavBar(driver)
				.manage()
				.manageUsers()
				.createNewUser()
				.setUsername(username)
				.setRealname(realname)
				.setEmail(email)
				.setAccessLevel(Strings.updater)
				.createUser();
		assertEquals(username, usersPage.getUsername(2));
		assertEquals(realname, usersPage.getRealName(2));
		assertEquals(email, usersPage.getEmail(2));
		assertEquals(Strings.updater, usersPage.getAccessLevel(2));
		usersPage.logout();
		
	}
	
}