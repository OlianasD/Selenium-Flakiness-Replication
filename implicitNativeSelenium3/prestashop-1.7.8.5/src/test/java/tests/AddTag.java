package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.PrestaLogin;
import po.TagsPage;

public class AddTag extends BaseTest {
	
	@Test
	public void test_add_tag(){
		TagsPage tags = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToTags()
				.addTag()
				.addTag("Hat");
		assertTrue(tags.getSuccessMessage().contains("Successful creation"));
	}
}
