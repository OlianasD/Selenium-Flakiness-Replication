package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeesPage extends ElementManagementPage {
	
	@FindBy(id = "page-header-desc-configuration-add")
	protected WebElement addEmployee;
	
	@FindBy(xpath = "//*[@id=\"employee_grid_table\"]/tbody/tr[2]/td[8]/div/div/a[1]")
    protected WebElement edit;
	
	public EmployeesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public RegisterEmployeePage addEmployee() {
		addEmployee.click();
		return new RegisterEmployeePage(driver);
	}
	
	public RegisterEmployeePage editEmployee() {
		edit.click();
		return new RegisterEmployeePage(driver);
	}

}
