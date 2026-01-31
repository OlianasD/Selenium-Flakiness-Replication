package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.IndexPage;
import po.UserPage;

public class Claroline_RemoveEnrolMultipleUsersTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		UserPage up  = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToUsersPage()
				.removeEnrol()
				.removeEnrol()
				.removeEnrol();
		
		assertTrue(!up.getBodyText(driver).contains("testuser1"));
		assertTrue(!up.getBodyText(driver).contains("testuser1"));
		assertTrue(!up.getBodyText(driver).contains("testuser1"));
		up.doLogout();
	}
}
