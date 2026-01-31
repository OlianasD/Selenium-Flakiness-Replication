package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.NewAccountPage;
import utils.Strings;

public class AddEmptyUserFailsTest extends BaseTest {

	@Test
	public void addEmptyUserFails() {
		
		NewAccountPage userPage = new BaseNavBar(driver)
			.manage()
			.manageUsers()
			.createNewUser()
			.createUserFails();
		
		assertEquals(Strings.errorInvalidUser, userPage.getError());
	}
	
}