package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.DesktopPage;
import po.IndexPage;

public class Claroline_LoginUserTest extends BaseTest {
	
	@Test
	public void runTest() throws InterruptedException{
		DesktopPage dp = new IndexPage(driver)
				.login("user001", "n0tl34k3dy3t");
		assertEquals("Firstname001 Name001", dp.getUserProfile());
		dp.doLogout();
	}
}
