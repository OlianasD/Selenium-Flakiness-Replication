package mediawiki;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import po.PageCreationPage;

public class CloseInitialEditorPopupTest extends BaseTest {

	@Test
	public void closeInitialEditorPopup() {
		PageCreationPage pcp = loginAsAdmin()
				.searchNonExisting("Software testing")
				.createNonExisting();
		assertTrue(pcp.isInitialPopupVisible());
		pcp.closeInitialPopup();
	}
	
}