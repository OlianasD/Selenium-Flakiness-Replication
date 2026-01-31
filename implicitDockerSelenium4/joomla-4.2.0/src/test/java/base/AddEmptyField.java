package base;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import po.EditFieldPage;

public class AddEmptyField extends BaseTest {
	
	@Test
	public void addEmptyField() {

		EditFieldPage field = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.sideContent()
			.fields()
			.createField()
			.saveError();
		
		assertEquals("Please fill in this field", field.getEmptyTitleAlert());

	}
}