package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.CourseCreatePage;
import po.IndexPage;

public class Claroline_AddPasswordCourseTest extends BaseTest {
	
	@Test
	public void addPasswordCourse() throws InterruptedException{
		CourseCreatePage ccp = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.addCourse()
				.addPasswordCourse("Course002", "002", "Humanities", "n0tl34k3dy3t");
		assertTrue(ccp.waitForMessageToBe("You have just created the course website : 002"));
		ccp.goToAdminPage().doLogout();
	}
}
