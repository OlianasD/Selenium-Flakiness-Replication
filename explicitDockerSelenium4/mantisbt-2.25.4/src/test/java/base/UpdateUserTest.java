package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.EditUserPage;

public class UpdateUserTest extends BaseTest {

	@Test
	public void updateUser() {
		String originalName = "username001";
		String expectedName = "username002";
		
		EditUserPage editUser = new BaseNavBar(driver)
				.manage()
				.manageUsers()
				.goToUser(originalName)
				.setRealName(expectedName)
				.updateUser();
		
		assertEquals(expectedName, editUser.getRealName());
		editUser.logout();
	}
	
}