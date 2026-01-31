package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminCoursesPage;
import po.IndexPage;

public class Claroline_SearchCourseTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		AdminCoursesPage acp = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.searchCourse("Course001");
		
		assertEquals("Course001", acp.getCourseName());
		assertEquals("001", acp.getCourseCode());
		acp.doLogout();
	}
}
