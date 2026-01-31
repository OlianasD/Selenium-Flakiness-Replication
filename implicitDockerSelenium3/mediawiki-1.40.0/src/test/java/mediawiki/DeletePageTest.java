package mediawiki;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import po.DeletePage;

public class DeletePageTest extends BaseTest {

	@Test
	public void deletePage() {
		DeletePage delete = loginAsAdmin()
				.searchExisting("E2E Web Testing")
				.deletePage()
				.delete();
		
		assertEquals("\"E2E Web Testing\" has been deleted. See deletion log for a record of recent deletions.", delete.getSuccessMessage());
	}
	
}