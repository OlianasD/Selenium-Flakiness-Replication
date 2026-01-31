package tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.LoginPage;
import po.PermissionsPage;




public class AuthorizedUsers extends BaseTest {

		  
	@Test()
	public void showAuthorizedUsers() {
		PermissionsPage permissions = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.firstProjectSummary()
				.permissions();
		
		assertEquals("admin", permissions.getFirstAllowedUser());
			  
	}
		  
		  
}
