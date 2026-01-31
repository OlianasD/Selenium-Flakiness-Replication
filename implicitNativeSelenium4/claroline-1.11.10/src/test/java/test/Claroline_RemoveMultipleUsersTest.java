package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminUsersPage;
import po.IndexPage;

public class Claroline_RemoveMultipleUsersTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		AdminUsersPage aup = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.searchUser("testuser")
				.removeUser()
				.removeUser()
				.removeUser();
		assertEquals("Deletion of the user was done sucessfully",aup.getMessage());
		assertTrue(!aup.getBodyText(driver).contains("testuser1"));
		assertTrue(!aup.getBodyText(driver).contains("testuser2"));
		assertTrue(!aup.getBodyText(driver).contains("testuser3"));
		aup.doLogout();
	}
}
