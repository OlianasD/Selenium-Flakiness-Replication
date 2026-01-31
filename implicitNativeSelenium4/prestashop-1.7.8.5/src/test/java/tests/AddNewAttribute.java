package tests;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.AttributesPage;
import po.PrestaLogin;

public class AddNewAttribute extends BaseTest {

	@Test
	public void test_add_attributes(){
			 
		AttributesPage attributes = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToAttributes()
				.clickAddAttribute()
				.setName("Quantity")
				.setPublicName("Qnt")
				.submitAttribute();
		
		assertTrue(attributes.getSuccessMessage().contains("Successful creation"));
	}
}
