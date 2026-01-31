package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AdminLoginPage;


public class LoginDeletedUserFailsTest extends BaseTest {

	@Test
	public void testExpressCartLoginUser() throws Exception {
		goToAdminHome();
		AdminLoginPage login = new AdminLoginPage(driver)
			.setEmail("test000@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.doBadLogin();
		assertEquals("A user with that email does not exist.", login.getDangerAlertText());
	}


}
