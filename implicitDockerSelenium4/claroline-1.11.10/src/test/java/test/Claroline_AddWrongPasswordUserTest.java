package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminAddNewUserPage;
import po.IndexPage;

public class Claroline_AddWrongPasswordUserTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		AdminAddNewUserPage aanup = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.addUser()
				.addNewStudent("user", "user", "user", "0v3rtlyC0mpl1c4t3dPsW", "D1ff3r3nt_0v3rtlyC0mpl1c4t3dPsW");
		
		assertEquals("You typed two different passwords",aanup.getMessage());
		aanup.doLogout();
	}
}
