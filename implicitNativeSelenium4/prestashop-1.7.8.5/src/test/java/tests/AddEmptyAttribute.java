package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.AddAttributePage;
import po.PrestaLogin;

public class AddEmptyAttribute extends BaseTest {

	@Test
	public void test_add_empty_attributes(){
			 
		AddAttributePage attributes = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToAttributes()
				.clickAddAttribute()
				.submitError();
		
		assertEquals("×\n"
				+ "There are 2 errors.\n"
				+ "The field name is required at least in English (English).\n"
				+ "The field public_name is required at least in English (English).", attributes.getAlertMessage());
	}
}
