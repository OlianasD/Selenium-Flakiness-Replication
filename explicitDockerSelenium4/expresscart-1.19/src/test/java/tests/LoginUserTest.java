package tests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminDashboardPage;
import po.AdminLoginPage;


public class LoginUserTest extends BaseTest {


	@Test
	public void testExpressCartLoginUser() throws Exception {
			goToAdminHome();
			AdminDashboardPage dashboard = new AdminLoginPage(driver)
				.setEmail("test000@test.com")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.doLogin();
			assertEquals(dashboard.getDashboardText(), "  Dashboard");
			dashboard.logout();		
	}



}
