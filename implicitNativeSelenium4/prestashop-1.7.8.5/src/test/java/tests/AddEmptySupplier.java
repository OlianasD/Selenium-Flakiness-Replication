package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import po.AddSupplierPage;
import po.PrestaLogin;


public class AddEmptySupplier extends BaseTest {

	@Test
	public void test_add_empty_supplier(){
		AddSupplierPage suppliers = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToManufacturer()
				.suppliersTab()
				.clickAddSupplier()
				.addEmptySupplier();
		
		assertEquals("Please fill out this field.", suppliers.getEmptyNameAlert());
	}
}
