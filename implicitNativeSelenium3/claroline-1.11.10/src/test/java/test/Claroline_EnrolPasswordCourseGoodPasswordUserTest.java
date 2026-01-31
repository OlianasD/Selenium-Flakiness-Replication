package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AuthCoursesPage;
import po.IndexPage;

public class Claroline_EnrolPasswordCourseGoodPasswordUserTest extends BaseTest {
	
	@Test
	public void enrolPasswordCourseGoodPassword() throws InterruptedException{
		AuthCoursesPage acp = new IndexPage(driver)
				.login("user001", "n0tl34k3dy3t")
				.enrolToCourse()
				.searchCourse("Course002")
				.enrolPassword("n0tl34k3dy3t");
		
		assertEquals("You've been enrolled on the course", acp.getMessage());
		acp.doLogout();
	}
}
