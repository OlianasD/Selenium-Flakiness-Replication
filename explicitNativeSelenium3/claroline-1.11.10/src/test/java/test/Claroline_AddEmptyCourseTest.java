package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.CourseCreatePage;
import po.IndexPage;

public class Claroline_AddEmptyCourseTest extends BaseTest {
	
	@Test
	public void addEmptyCourse() throws InterruptedException{
		CourseCreatePage ccp = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goToAdminPage()
				.addCourse()
				.addEmptyCourse();
		
		assertEquals("Course title needed", ccp.getErrorMsg(1));
		assertEquals("Course code needed", ccp.getErrorMsg(2));
		ccp.doLogout();
	}
}
