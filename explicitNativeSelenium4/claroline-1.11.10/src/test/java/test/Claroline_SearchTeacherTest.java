package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminUsersPage;
import po.IndexPage;

public class Claroline_SearchTeacherTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		AdminUsersPage aup = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.advancedSearch()
				.search("testuser2", "Course creator");
		
		assertEquals("testuser2",aup.getLastName());
		aup.doLogout();
	}
}
