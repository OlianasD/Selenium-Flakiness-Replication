package tests;


import po.AdminLoginPage;
import po.NewUserPage;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AddEmptyUserTest extends BaseTest {

	@Test
	public void testExpressCartEmptyUser() throws Exception {
			goToAdminHome();
			NewUserPage user = new AdminLoginPage(driver)
				.setEmail("owner@test.com")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.doLogin()
				.newUser()
				.addUserError();
			Thread.sleep(1000);
			assertTrue(user.usernameFieldHasError());
			assertTrue(user.emailFieldHasError());
			assertTrue(user.passwordFieldHasError());
			assertTrue(user.passwordConfirmFieldHasError());
			
	}


}
