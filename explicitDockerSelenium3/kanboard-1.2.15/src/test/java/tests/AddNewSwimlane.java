package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.LoginPage;
import po.SwimlanesPage;




public class AddNewSwimlane extends BaseTest {
		  
	@Test()
	public void addNewSwimlane() {
		SwimlanesPage swimlanes = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.firstProjectSummary()
				.swimlanes()
				.addSwimlane()
				.setName("New Swimlane 3")
				.save();
		assertTrue(swimlanes.getLastSwimlaneName().contains("New Swimlane 3"));
			  
	}
		  
		  
		  
}
