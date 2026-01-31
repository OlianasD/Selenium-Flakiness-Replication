package mediawiki;

import org.junit.Test;
import po.PageCreationPage;

import static org.junit.Assert.assertTrue;

public class CloseInitialEditorUserPopupTest extends BaseTest {

	@Test
	public void closeInitialEditorPopup() {
		PageCreationPage pcp = loginAsUser()
				.searchNonExisting("Software testing")
				.createNonExisting();
		assertTrue(pcp.isInitialPopupVisible());
		pcp.closeInitialPopup();
	}
	
}