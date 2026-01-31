package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.CourseCreatePage;
import po.IndexPage;

public class Claroline_AddDeniedCourseTest extends BaseTest {
	
	@Test
	public void addDeniedCourse() throws InterruptedException{
		CourseCreatePage ccp = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.addCourse()
				.addDeniedCourse("Course003", "003", "Humanities");

		assertTrue(ccp.waitForMessageToBe("You have just created the course website : 003"));
		ccp.goToAdminPage().doLogout();
	}
}
