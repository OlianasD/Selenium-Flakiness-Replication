package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import po.ColumnsPage;
import po.LoginPage;




public class AddNewColumn extends BaseTest {

		  
	@Test()
	public void addNewColumn() {
		ColumnsPage columns = new LoginPage(driver)
				.loginToKanboard("admin", password)
				.firstProjectSummary()
				.columns()
				.addColumn()
				.setColumnName("New Column 3")
				.save();
		
		assertTrue(columns.getLastColumnName().contains("New Column 3"));
			  
	}
		  
		  
		  
}
