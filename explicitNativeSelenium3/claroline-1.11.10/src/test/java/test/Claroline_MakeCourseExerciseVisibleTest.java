package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ExercisePage;
import po.IndexPage;

public class Claroline_MakeCourseExerciseVisibleTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		ExercisePage ep = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToExercisePage();
		
		assertEquals("Make visible", ep.getExerciseVisibilityTitle());
		ep.makeExerciseVisible();
		assertEquals("Make invisible", ep.getExerciseVisibilityTitle());
		ep.doLogout();
	}
}
