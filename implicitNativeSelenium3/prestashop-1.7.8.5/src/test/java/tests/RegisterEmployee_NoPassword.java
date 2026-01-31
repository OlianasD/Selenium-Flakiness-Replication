package tests;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import po.PrestaLogin;
import po.RegisterEmployeePage;


public class RegisterEmployee_NoPassword extends BaseTest {

	@Test
	public void test_register_employee_no_passsword(){
		RegisterEmployeePage employee = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToEmployees()
				.addEmployee()
				.addEmployeeNoPassword("John", "Smith", "smith@gmail.com");
		
		
		assertEquals("Please fill out this field.", employee.getEmptyPasswordAlert());
	 }
}
