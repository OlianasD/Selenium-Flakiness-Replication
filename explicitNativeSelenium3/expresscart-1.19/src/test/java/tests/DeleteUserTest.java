package tests;


import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.AdminLoginPage;
import po.UsersPage;



public class DeleteUserTest extends BaseTest {


	@Test
	public void testExpressCartDeleteUser() throws Exception {
		goToAdminHome();
		UsersPage users = new AdminLoginPage(driver)
			.setEmail("owner@test.com")
			.setPassword("e2eW3Bt3s71nGB3nchM4rK")
			.doLogin()
			.users()
			.deleteThirdUser()
			.users();
		assertFalse(users.containsUser("test000@test.com"));
	}



}
