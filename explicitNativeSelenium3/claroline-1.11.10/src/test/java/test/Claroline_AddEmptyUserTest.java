package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminAddNewUserPage;
import po.IndexPage;

public class Claroline_AddEmptyUserTest extends BaseTest {
	
	
	@Test
	public void runTest() throws InterruptedException{
		AdminAddNewUserPage aanup = new IndexPage(driver)
			.login("admin", "n0tl34k3dy3t")
			.goToAdminPage()
			.addUser()
			.addNewStudent("", "", "", "", "");
		assertTrue(aanup.waitForMessageToBe("You left some required fields empty"));
		aanup.doLogout();
	}
}
