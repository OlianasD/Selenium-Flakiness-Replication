package tests;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import po.PrestaLogin;
import po.RegisterEmployeePage;


public class RegisterEmployee_NoName extends BaseTest {

	@Test
	public void test_register_employee_no_name(){
		RegisterEmployeePage employee = new PrestaLogin(driver)
				.loginToPresta(adminMail, adminPsw)
				.goToEmployees()
				.addEmployee()
				.addEmployeeNoName("fake@gmail.com","abcd!@#$23");
		
		assertEquals("Please fill out this field.", employee.getEmptyNameAlert());
	 }
}
