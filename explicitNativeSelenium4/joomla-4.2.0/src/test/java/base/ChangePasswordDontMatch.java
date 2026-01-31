package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.BaseNavBar;
import po.EditProfilePage;

public class ChangePasswordDontMatch extends BaseTest {
	
	@Test
	public void changePasswordDontMatch() {
		String username = "tuser01";
		String password = "newpassword01";
		
		EditProfilePage profile = new BaseNavBar(driver)
				.authorLogin()
				.setUsername(username)
				.setPassword(password)
				.login()
				.editProfile()
				.setPassword("asdasdasd22")
				.confirmPassword("zxczxczxc23")
				.submit();
		
		assertEquals("The passwords you entered do not match. Please enter your desired password in the password field and confirm your entry by entering it in the confirm password field.", profile.getAlertMessage());
		
	}
}