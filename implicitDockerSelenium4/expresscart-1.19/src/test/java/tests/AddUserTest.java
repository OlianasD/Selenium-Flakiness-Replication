package tests;


import po.AdminLoginPage;
import po.UsersPage;

import static org.junit.Assert.assertEquals;



import org.junit.Test;


public class AddUserTest extends BaseTest {

	@Test
	public void testExpressCartNewUser() throws Exception {
			goToAdminHome();
			UsersPage users = new AdminLoginPage(driver)
				.setEmail("owner@test.com")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.doLogin()
				.newUser()
				.setUsername("TestUser000")
				.setEmail("test000@test.com")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.setConfirmPassword("e2eW3Bt3s71nGB3nchM4rK")
				.addUser()
				.users();
			Thread.sleep(2000);
			assertEquals(users.getThirdUserText(), "User: TestUser000 - (test000@test.com)\nRole: User");
			users.logout();
		
	}


}
