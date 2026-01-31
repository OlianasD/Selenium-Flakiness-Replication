package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterEmployeePage {
	WebDriver driver;
	@FindBy(id = "page-header-desc-employee-new_employee")
	WebElement addEmployee;
	@FindBy(id = "employee_firstname")
	WebElement firstname;
	@FindBy(id = "employee_lastname")
	WebElement lastname;
	@FindBy(id = "employee_password")
	WebElement passwd;
	@FindBy(id = "employee_email")
	WebElement email;
	@FindBy(id = "id_profile")
	WebElement permission;
	@FindBy(id = "save-button")
	WebElement submitAddEmployee;
	@FindBy(xpath = "//*[@id=\"form-supplier\"]/div/div[2]/table/tbody/tr/td[6]/div/div/button")
	WebElement dropDownMeny;
	@FindBy(xpath = "//*[@id=\"form-supplier\"]/div/div[2]/table/tbody/tr/td[6]/div/div/ul/li[3]/a")
	WebElement remove;
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div")
	WebElement alertMsg;

	public RegisterEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public EmployeesPage addEmployee(String nameStr, String lastnameStr, String emailStr, String passStr) {
		firstname.sendKeys(nameStr);
		lastname.sendKeys(lastnameStr);
		email.sendKeys(emailStr);
		passwd.sendKeys(passStr);
		submitAddEmployee.click();
		return new EmployeesPage(driver);
	}
	
	public RegisterEmployeePage addEmployeeNoName(String emailStr, String passStr) {
		email.sendKeys(emailStr);
		passwd.sendKeys(passStr);
		submitAddEmployee.click();
		return new RegisterEmployeePage(driver);
	}
	
	public RegisterEmployeePage addEmployeeNoPassword(String nameStr, String lastnameStr, String emailStr) {
		firstname.sendKeys(nameStr);
		lastname.sendKeys(lastnameStr);
		email.sendKeys(emailStr);
		submitAddEmployee.click();
		return new RegisterEmployeePage(driver);
	}
	
	public RegisterEmployeePage addEmployeeNoEmail(String nameStr, String lastnameStr, String passStr) {
		firstname.sendKeys(nameStr);
		lastname.sendKeys(lastnameStr);
		passwd.sendKeys(passStr);
		submitAddEmployee.click();
		return new RegisterEmployeePage(driver);
	}
	
	public RegisterEmployeePage addEmployeeNoPermission(String nameStr, String lastnameStr, String emailStr, String passStr) {
		firstname.sendKeys(nameStr);
		lastname.sendKeys(lastnameStr);
		email.sendKeys(emailStr);
		passwd.sendKeys(passStr);
		submitAddEmployee.click();
		return new RegisterEmployeePage(driver);
	}

	public EmployeesPage editEmployee(String lastnameStr) {
		lastname.clear();
		lastname.sendKeys(lastnameStr);
		submitAddEmployee.click();
		return new EmployeesPage(driver);
	}
	
	public String getAlertMessage() {
		return alertMsg.getText();
	}
	
	public String getEmptyNameAlert() {
		return firstname.getAttribute("validationMessage");
	}
	
	public String getEmptyMailAlert() {
		return email.getAttribute("validationMessage");
	}
	
	public String getEmptyPasswordAlert() {
		return passwd.getAttribute("validationMessage");
	}

}
