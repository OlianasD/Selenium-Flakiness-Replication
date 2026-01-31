package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.LoginPage;
import po.UserSummaryPage;




public class EditProfile extends BaseTest {
	
	@Test()
	public void editProfile() {
		UserSummaryPage user = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.goToSettings()
				.usersManagement()
				.goToUser("admin")
				.editProfile()
				.setEmail("admin@kanboard.com")
				.save();
		
		assertEquals("admin@kanboard.com", user.getEmail());
			  
	}
		  

		  
}
