package tests;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.AddressesPage;
import po.PrestaLogin;


public class AddNewAddress extends BaseTest {

	@Test
	public void test_add_address(){
		AddressesPage addresses = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToAddresses()
				.addAddress()
				.addAddress("anonymous@psgdpr.com","Test","John","DOE","Via Torino","12345","123456789","987654321","Bologna");
		
		assertTrue(addresses.getSuccessMessage().contains("Successful creation"));
	}
}
