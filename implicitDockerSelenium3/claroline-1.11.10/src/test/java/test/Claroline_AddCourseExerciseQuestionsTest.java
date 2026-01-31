package test;

import static org.junit.Assert.*;

import org.junit.Test;
import po.EditExercisePage;
import po.IndexPage;

public class Claroline_AddCourseExerciseQuestionsTest extends BaseTest {
	
	
	@Test
	public void runTest() throws InterruptedException{
		EditExercisePage eep = new IndexPage(driver)
			.login("admin", "n0tl34k3dy3t")
			.goInsideCourse()
			.goToExercisePage()
			.editExercise()
			.newQuestion()
			.addMCUAQuestion("Question 1")
			.addMCUA("3", "-3")
			.newQuestion()
			.addTFQuestion("Question 2")
			.addTFA("3", "-3")
			.newQuestion()
			.addMCMAQuestion("Question 3")
			.addMCMA("3", "0", "-3")
			.goToEditExercisePage();
		
		assertEquals("Question 1", eep.getQuestionTitle(1));
		assertEquals("Question 2", eep.getQuestionTitle(2));
		assertEquals("Question 3", eep.getQuestionTitle(3));
		assertEquals("Multiple choice (Unique answer)", eep.getQuestionKind(1));
		assertEquals("True/False", eep.getQuestionKind(2));
		assertEquals("Multiple choice (Multiple answers)", eep.getQuestionKind(3));
		eep.doLogout();
		
	}
}
