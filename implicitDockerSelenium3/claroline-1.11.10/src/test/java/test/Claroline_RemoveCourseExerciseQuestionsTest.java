package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.EditExercisePage;
import po.IndexPage;

public class Claroline_RemoveCourseExerciseQuestionsTest extends BaseTest {
	
	@Test
	public void removeCourseExerciseQuestions() throws InterruptedException{
		EditExercisePage eep = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToExercisePage()
				.editExercise()
				.removeQuestion(1)
				.removeQuestion(1)
				.removeQuestion(1);
		
		assertTrue(!eep.getBodyText(driver).contains("Question 1"));
		assertTrue(!eep.getBodyText(driver).contains("Question 2"));
		assertTrue(!eep.getBodyText(driver).contains("Question 3"));
		eep.doLogout();
	}
}
