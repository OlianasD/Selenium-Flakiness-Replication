package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import po.AddTagPage;
import po.PrestaLogin;


public class AddEmptyTag extends BaseTest {
	
	@Test
	public void test_add_empty_tag(){
		AddTagPage tag = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToTags()
				.addTag()
				.addEmptyTag();
		
		assertEquals("×\n"
		 		+ "The name field is required.", tag.getAlertMessage());
	}
}
