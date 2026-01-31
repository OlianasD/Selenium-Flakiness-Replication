package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AddAddressPage;
import po.PrestaLogin;


public class AddEmptyAddress extends BaseTest {

	@Test
	public void test_add_empty_address(){
		AddAddressPage address = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToAddresses()
				.addAddress()
				.addEmptyAddress();
		
		assertEquals("Please fill out this field.", address.getEmailEmptyAlert());
	}
}
