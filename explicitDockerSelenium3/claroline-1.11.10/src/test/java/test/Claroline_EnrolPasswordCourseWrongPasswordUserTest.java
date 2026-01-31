package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AuthCoursesPage;
import po.IndexPage;

public class Claroline_EnrolPasswordCourseWrongPasswordUserTest extends BaseTest {
	
	@Test
	public void enrolPasswordCourseWrongPassword() throws InterruptedException{
		AuthCoursesPage acp = new IndexPage(driver)
				.login("user001", "n0tl34k3dy3t")
				.enrolToCourse()
				.searchCourse("Course002")
				.enrolPassword("0v3rtlyC0mpl1c4t3dPsW");
		
		assertTrue(acp.waitForMessageToBe("Invalid enrolment key given"));
		acp.doLogout();
	}
}
