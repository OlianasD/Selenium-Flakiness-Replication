package tests;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import po.PrestaLogin;
import po.RegisterEmployeePage;


public class RegisterEmployee_NoPermission extends BaseTest {

	@Test
	public void test_register_employee_no_permission(){
		RegisterEmployeePage employee = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToEmployees()
				.addEmployee()
				.addEmployeeNoPermission("John", "Smith", "fake@mail.com","abcd!@#$23");
		
		
		assertEquals("�\n"
				+ "The id_profile field is required.", employee.getAlertMessage());
	 }
}
