package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.AdminCoursesPage;
import po.IndexPage;

public class Claroline_SearchAndRemovePasswordCourseTest extends BaseTest {
	
	@Test
	public void searchAndRemovePasswordCourse() throws InterruptedException{
		AdminCoursesPage acp = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.advancedCourseSearch()
				.searchPassword("Course002");
		
		assertEquals("Course002",acp.getCourseName());
		acp.removeCourse();
		assertTrue(acp.waitForMessageToBe("The course has been successfully deleted"));
		acp.doLogout();
	}
}
