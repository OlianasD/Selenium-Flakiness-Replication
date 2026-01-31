package base;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageUsersPage;

public class DeleteUserTest extends BaseTest {

	@Test
	public void deleteUser() {
		String userName = "username001";

		ManageUsersPage manageUsers = new BaseNavBar(driver)
				.manage()
				.manageUsers()
				.goToUser(userName)
				.deleteUser()
				.confirmDelete();
		
		assertFalse(manageUsers.isUserPresent(userName));
		manageUsers.logout();
	}
	
}