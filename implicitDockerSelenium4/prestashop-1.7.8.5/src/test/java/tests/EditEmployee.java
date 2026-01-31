package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.EmployeesPage;
import po.PrestaLogin;

public class EditEmployee extends BaseTest {

	@Test()
	public void test_update_employee(){
		EmployeesPage employees = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToEmployees()
				.editEmployee()
				.editEmployee("Main Admin");
		assertTrue(employees.getSuccessMessage().contains("Successful update"));
	}	 
}
