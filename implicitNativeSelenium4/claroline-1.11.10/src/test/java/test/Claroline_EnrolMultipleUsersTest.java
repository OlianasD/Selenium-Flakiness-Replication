package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.IndexPage;
import po.UserPage;

public class Claroline_EnrolMultipleUsersTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{

		UserPage up = new IndexPage(driver)
				.login("testuser1", "n0tl34k3dy3t")
				.enrolToCourse()
				.searchCourse("Course001")
				.enrol()
				.doLogoutAndGoHome(driver)
				.login("testuser2", "n0tl34k3dy3t")
				.enrolToCourse()
				.searchCourse("Course001")
				.enrol()
				.doLogoutAndGoHome(driver)
				.login("testuser3", "n0tl34k3dy3t")
				.enrolToCourse()
				.searchCourse("Course001")
				.enrol()
				.doLogoutAndGoHome(driver)
				.login("admin", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToUsersPage();
		
		assertTrue(up.getBodyText(driver).contains("testuser1"));
		assertTrue(up.getBodyText(driver).contains("testuser2"));
		assertTrue(up.getBodyText(driver).contains("testuser3"));
		up.doLogout();
		
	}
}
