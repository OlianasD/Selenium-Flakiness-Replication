package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminCoursesPage;
import po.IndexPage;

public class Claroline_SearchAndRemoveDeniedCourseTest extends BaseTest {
	
	@Test
	public void searchAndRemoveDeniedCourse() throws InterruptedException{
		AdminCoursesPage acp = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.advancedCourseSearch()
				.searchDenied("Course003");
		assertEquals("Course003",acp.getCourseName());
		acp.removeCourse(3);
		assertEquals("The course has been successfully deleted",acp.getMessage());
		acp.doLogout();
	}
}
