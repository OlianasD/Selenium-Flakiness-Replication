package base;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import po.CreateCategoryPage;

public class AddEmptyCategory extends BaseTest {
	
	@Test
	public void addEmptyCategory() {

		CreateCategoryPage cat = loginAsAdmin()
			.siteAdmin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login()
			.categories()
			.addCategory()
			.saveError();
		
		assertEquals("Please fill in this field", cat.getEmptyTitleAlert());

	}
}
