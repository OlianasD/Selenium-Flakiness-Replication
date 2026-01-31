package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminCoursesPage;
import po.IndexPage;

public class Claroline_SearchAllowedCourseTest extends BaseTest {
	
	@Test
	public void searchAllowedCourse() throws InterruptedException{
		
		AdminCoursesPage acp = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.advancedCourseSearch()
				.searchAllowed("Course001");
		assertEquals("Course001",acp.getCourseName());
		acp.doLogout();
		
	}
}
