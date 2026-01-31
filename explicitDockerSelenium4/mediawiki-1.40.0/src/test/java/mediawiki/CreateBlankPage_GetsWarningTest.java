package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.PageCreationPage;

public class CreateBlankPage_GetsWarningTest extends BaseTest {

	@Test
	public void createBlankPage_GetsWarning() {
		String res = "Warning: The page you are creating is blank. If you click \"Save page\" again, the page will be created without any content.";
		PageCreationPage editor = loginAsAdmin()
				.searchNonExisting("Empty")
				.createNonExisting()
				.saveEmpty();
		
		assertEquals(res, editor.getBlankPageWarning());

	}
	
}