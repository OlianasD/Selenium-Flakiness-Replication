package tests;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import po.PrestaLogin;
import po.RegisterEmployeePage;


public class RegisterEmployee_NoEmail extends BaseTest {

	@Test
	public void test_register_employee_no_email(){
		RegisterEmployeePage employee = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToEmployees()
				.addEmployee()
				.addEmployeeNoEmail("John", "Smith", "abcd!@#$23");
		
		assertEquals("Please fill out this field.", employee.getEmptyMailAlert());
		
		
	 }
}
