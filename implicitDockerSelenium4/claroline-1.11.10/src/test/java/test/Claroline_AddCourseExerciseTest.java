package test;

import static org.junit.Assert.*;


import org.junit.Test;
import po.EditExercisePage;
import po.IndexPage;


public class Claroline_AddCourseExerciseTest extends BaseTest {

	@Test
	public void runTest() throws InterruptedException{
		EditExercisePage eep = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToExercisePage()
				.newExercise()
				.addExercise("Exercise 001");
		
		assertEquals("Exercise added", eep.getCourseMessage());
		eep.doLogout();
	}
}
