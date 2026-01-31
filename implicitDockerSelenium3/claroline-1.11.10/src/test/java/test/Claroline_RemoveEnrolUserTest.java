package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AuthCoursesPage;
import po.IndexPage;

public class Claroline_RemoveEnrolUserTest extends BaseTest {
	
	@Test
	public void removeEnrolUser() throws InterruptedException{
		AuthCoursesPage acp = new IndexPage(driver)
				.login("user001", "n0tl34k3dy3t")
				.removeEnrolFromCourse()
				.removeEnrol();
		
		assertEquals("Your enrollment on the course has been removed", acp.getMessage());
		acp.doLogout();
	}
}
