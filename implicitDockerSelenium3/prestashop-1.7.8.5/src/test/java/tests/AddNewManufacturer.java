package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.ManufacturerPage;
import po.PrestaLogin;


public class AddNewManufacturer extends BaseTest {

	@Test
	public void test_add_manufacturer(){
		ManufacturerPage manufacturers = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToManufacturer()
				.clickAddManufacturer()
				.addManufacturer("Smith");
		
		assertTrue(manufacturers.getSuccessMessage().contains("Successful creation"));
	}
}
