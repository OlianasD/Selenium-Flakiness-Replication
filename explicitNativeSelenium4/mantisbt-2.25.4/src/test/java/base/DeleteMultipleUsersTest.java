package base;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.BaseNavBar;
import po.ManageUsersPage;

public class DeleteMultipleUsersTest extends BaseTest {

	@Test
	public void deleteMultipleUsers() {
		String username = "username00%d";

		ManageUsersPage manageUsers = new BaseNavBar(driver)
				.manage()
				.manageUsers();
		
		for(int i=1; i<=3; i++) {
			manageUsers = manageUsers
					.goToUser(String.format(username, i))
					.deleteUser()
					.confirmDelete();
			
			assertFalse(manageUsers.isUserPresent(String.format(username, i)));
		}
	}
	
}