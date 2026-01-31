package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminAddNewUserPage;
import po.IndexPage;

public class Claroline_AddUserTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		AdminAddNewUserPage aanup = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.addUser()
				.addNewStudent("Name001", "Firstname001", "user001", "n0tl34k3dy3t", "n0tl34k3dy3t");

		assertTrue(aanup.waitForMessageToBe("The new user has been sucessfully created"));
		aanup.doLogout();
	}
	
	
	
}
