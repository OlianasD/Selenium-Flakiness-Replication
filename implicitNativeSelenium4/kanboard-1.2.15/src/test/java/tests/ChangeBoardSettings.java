package tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import po.BoardSettingsPage;
import po.LoginPage;





public class ChangeBoardSettings extends BaseTest {

		  
	@Test
	public void changeBoardSettings() {
		BoardSettingsPage boardSettings = new LoginPage(driver)
			.loginToKanboard("admin", password)
			.goToSettings()
			.boardSettings()
			.setPublicrefreshIntgerval("85")
			.save()
			.appSettings()
			.boardSettings();
		
		assertEquals("85", boardSettings.getPublicRefreshInterval());
	
	}
		  
		  
}
