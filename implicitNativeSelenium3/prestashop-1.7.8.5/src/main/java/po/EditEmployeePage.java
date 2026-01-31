package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditEmployeePage {
	WebDriver driver;
	@FindBy(id = "page-header-desc-employee-new_employee")
	WebElement addEmployee;
	@FindBy(xpath = "//*[@id=\"form-employee\"]/div/div[2]/table/tbody/tr[1]/td[8]/div/a")
	WebElement edit;
	@FindBy(id = "lastname")
	WebElement lastname;
	@FindBy(id = "employee_form_submit_btn")
	WebElement submitEditEmployee;
	@FindBy(xpath = "//*[@id=\"form-supplier\"]/div/div[2]/table/tbody/tr/td[6]/div/div/ul/li[3]/a")
	WebElement remove;

	public EditEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void editEmployee(String lastnameStr) {
		lastname.clear();
		lastname.sendKeys(lastnameStr);
		submitEditEmployee.click();
	}

}
