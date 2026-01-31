package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import po.AdminLogin;
import po.ContentPage;
import po.DraftPage;

public class AddAsDraftTest extends BaseTest {
	
	@Test
	public void addAsDraft() {
		ContentPage content = new AdminLogin(driver)
				.setUsername(username)
				.setPassword(password)
				.login()
				.newContent()
				.setTitle("Draft Content")
				.setDraft()
				.saveAndReturnToContentPage();
		assertFalse(content.getFirstContentTitle().contains("Draft Content"));
		DraftPage drafts = content.drafts();
		assertEquals("Draft Content", drafts.getFirstDraftTitle());
		
	}
}