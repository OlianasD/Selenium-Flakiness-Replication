package tests;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import po.EmployeesPage;
import po.PrestaLogin;


public class RegisterEmployee extends BaseTest {

	@Test
	public void test_register_employee(){
		EmployeesPage employees = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToEmployees()
				.addEmployee()
				.addEmployee("John", "Smith", "smith@gmail.com","abcd!@#$23");
		
		assertTrue(employees.getSuccessMessage().contains("Successful creation"));
	 }
}
