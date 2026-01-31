package test;

import static org.junit.Assert.*;

import org.junit.Test;
import po.CalendarAgendaPage;
import po.IndexPage;

public class Claroline_AddCourseEventTest extends BaseTest {

	
	@Test
	public void runTest() throws InterruptedException{
		CalendarAgendaPage cap = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToCalendarAgendaPage()
				.addEvent("Exam 001", "31", "May", "2026", "Genoa");
		
		assertEquals("Event added to the agenda.", cap.getCourseMessage());
		cap.doLogout();
	}
}
