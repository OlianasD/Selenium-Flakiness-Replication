package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminAddNewUserPage;
import po.IndexPage;

public class Claroline_AddWrongEmailUserTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		AdminAddNewUserPage aanup = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.addUser()
				.addNewEmailStudent("user", "user", "user", "n0tl34k3dy3t", "n0tl34k3dy3t", "email");
		
		assertEquals("The email address is not valid",aanup.getMessage());
		aanup.doLogout();
	}
}
