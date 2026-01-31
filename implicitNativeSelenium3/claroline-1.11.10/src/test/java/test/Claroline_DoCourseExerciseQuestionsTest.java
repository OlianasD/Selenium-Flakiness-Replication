package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.ExerciseSubmitPage;
import po.IndexPage;

public class Claroline_DoCourseExerciseQuestionsTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		ExerciseSubmitPage esp = new IndexPage(driver)
				.login("user001", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToExercisePage()
				.goInsideExercise()
				.doExercise();

		assertEquals("Your total score is 9/9",esp.getResult());
		esp.doLogout();
	}
}
