package tests;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.ManufacturerPage;
import po.PrestaLogin;

public class EditManufacturer extends BaseTest {

	@Test()
	public void test_edit_manufacturer_address(){
		ManufacturerPage manufacturers = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToManufacturer()
				.editManufacturer()
				.addManufacturer("Smith Co");
		
		assertTrue(manufacturers.getSuccessMessage().contains("Successful update"));
	}	 
}
