package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.PrestaLogin;
import po.SupplierPage;


public class AddNewSupplier extends BaseTest {

	@Test
	public void test_add_supplier(){
		SupplierPage suppliers = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToManufacturer()
				.suppliersTab()
				.clickAddSupplier()
				.addSupplier("John", "Via Fianle Ligure", "Finale Ligure");
		
		assertTrue(suppliers.getSuccessMessage().contains("Successful creation"));
	}
}
