package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.CalendarAgendaPage;
import po.IndexPage;

public class Claroline_RemoveCourseEventTest extends BaseTest {
	
	@Test
	public void removeCourseEvent() throws InterruptedException{
		CalendarAgendaPage cap = new IndexPage(driver)
				.login("admin", "n0tl34k3dy3t")
				.goInsideCourse()
				.goToCalendarAgendaPage()
				.removeEvent();
		
		assertEquals("All events deleted from the agenda", cap.getCourseMessage());
		cap.doLogout();
	}
}
