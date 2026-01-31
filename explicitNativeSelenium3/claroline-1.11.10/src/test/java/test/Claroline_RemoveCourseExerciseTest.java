package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.ExercisePage;
import po.IndexPage;

public class Claroline_RemoveCourseExerciseTest extends BaseTest {
	
	@Test
	public void removeCourseExerciseTest() throws InterruptedException{
		ExercisePage ep = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToExercisePage();
		
		assertTrue(ep.getBodyText(driver).contains("Exercise 001"));
		ep.removeExercise();
		assertTrue(!ep.getBodyText(driver).contains("Exercise 001"));
		ep.doLogout();
	}
}
