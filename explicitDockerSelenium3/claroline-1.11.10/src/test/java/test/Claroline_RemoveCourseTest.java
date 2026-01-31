package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminCoursesPage;
import po.IndexPage;

public class Claroline_RemoveCourseTest extends BaseTest {
	
	@Test
	public void removeCourseTest() throws InterruptedException{
		AdminCoursesPage acp = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.searchCourse("Course001")
				.removeCourse();

		assertTrue(acp.waitForMessageToBe("The course has been successfully deleted"));
		acp.doLogout();
	}
}
