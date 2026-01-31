package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ProjectSidebar extends TopNavBar {
	
	@FindBy(linkText = "Edit project")
	protected WebElement edit;
	
	@FindBy(linkText = "Columns")
	protected WebElement columns;
	
	@FindBy(linkText = "Swimlanes")
	protected WebElement swimlanes;
	
	@FindBy(linkText = "Categories")
	protected WebElement categories;
	
	@FindBy(linkText =  "Permissions")
	protected WebElement permissions;
	
	@FindBy(linkText =  "Remove")
	protected WebElement remove;

	public ProjectSidebar(WebDriver driver) {
		super(driver);
	}
	
	public EditProjectPage editProject() {
		wait.waitClickability(edit);
		edit.click();
		return new EditProjectPage(driver);
	}
	
	public ProjectSummaryPage summary() {
		WebElement summary = wait.waitClickabilityRefreshed(By.linkText("Summary"));
		summary.click();
		return new ProjectSummaryPage(driver);
	}
	
	public ColumnsPage columns() {
		wait.waitClickability(columns);
		columns.click();
		return new ColumnsPage(driver);
	}
	
	public SwimlanesPage swimlanes() {
		wait.waitClickability(swimlanes);
		swimlanes.click();
		return new SwimlanesPage(driver);
	}
	
	public CategoriesPage categories() {
		wait.waitClickability(categories);
		categories.click();
		return new CategoriesPage(driver);
	}
	
	public PermissionsPage permissions() {
		wait.waitClickability(permissions);
		permissions.click();
		return new PermissionsPage(driver);
	}
	
	public ProjectListPage remove() {
		wait.waitClickability(remove);
		remove.click();
		By locator = By.id("modal-confirm-button");
		wait.waitClickability(locator).click();
		return new ProjectListPage(driver);
	}

}
