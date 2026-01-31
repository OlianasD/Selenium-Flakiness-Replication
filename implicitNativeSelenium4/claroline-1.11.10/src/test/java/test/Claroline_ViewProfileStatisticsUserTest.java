package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.IndexPage;
import po.TrackUserReportPage;

public class Claroline_ViewProfileStatisticsUserTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		TrackUserReportPage turp = new IndexPage(driver)
				.login("user001", "n0tl34k3dy3t")
				.goToMyUserAccount()
				.viewStats()
				.selectCourseStatistics("Course001");
		
		assertEquals("Exercise 001", turp.getExeName());
		assertEquals("9", turp.getExeResult());
		turp.doLogout();
	}
}
