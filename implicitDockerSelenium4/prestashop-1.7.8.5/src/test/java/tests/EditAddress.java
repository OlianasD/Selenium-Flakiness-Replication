package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.AddressesPage;
import po.PrestaLogin;


public class EditAddress extends BaseTest {

	@Test()
	public void test_edit_address(){
		AddressesPage addresses = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToAddresses()
				.editAddress()
				.editName("Bob");
		
		assertTrue(addresses.getSuccessMessage().contains("Update successful"));
	}
}
