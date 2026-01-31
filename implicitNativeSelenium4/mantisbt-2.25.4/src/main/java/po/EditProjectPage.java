package po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Strings;

public class EditProjectPage extends CreateProjectPage {
	
	@FindBy(xpath = "//*[@id=\"project-add-category-form\"]/fieldset/input[3]")
	protected WebElement categoryInput;
	
	@FindBy(xpath = "//*[@id=\"project-add-category-form\"]/fieldset/input[4]")
	protected WebElement addCategoryBtn;
	
	@FindBy(xpath = "//*[@id=\"categories\"]/div/div[3]/div/div/table/tbody/tr[1]/td[1]")
	protected WebElement projectCategory;
	
	@FindBy(id = "project-status")
	protected WebElement projectStatus;
	
	@FindBy(id = "project-view-state")
	protected WebElement viewState;
	
	@FindBy(id = "project-description")
	protected WebElement projectDescription;
	
	@FindBy(xpath = "//*[@id=\"manage-proj-update-form\"]/div/div[3]/input")
	protected WebElement updateProjectBtn;
	
	@FindBy(xpath = "//*[@id=\"categories\"]/div/div[3]/div/div/table/tbody/tr[1]/td[3]/div/div[1]/form/button")
	protected WebElement editCategoryBtn;
	
	@FindBy(xpath = "//*[@id=\"project-delete-form\"]/fieldset/input[3]")
	protected WebElement deleteProjectBtn;
	
	@FindBy(xpath = "//*[@id=\"categories\"]/div/div[3]/div/div/table/tbody/tr[1]/td[3]/div/div[2]/form/button")
	protected WebElement deleteCategoryBtn;
	
	@FindBy(xpath = "//*[@id=\"manage-project-update-subprojects-div\"]/div/div[2]/form/button")
	protected WebElement createSubprojectBtn;
	
	@FindBy(xpath = "//*[@id=\"manage-project-update-subprojects-form\"]/div/div[2]/div/fieldset/div/table/tbody/tr[1]/td[7]/div/a[2]")
	protected WebElement unlinkFirstSubproject;
	
	@FindBy(xpath = "//*[@id=\"manage-project-subproject-add-form\"]/div/div/fieldset/input[3]")
	protected WebElement linkSubprojectBtn;

	public EditProjectPage(WebDriver driver) {
		super(driver);
	}
	
	public EditProjectPage enterCategory(String category) {
		categoryInput.clear();
		categoryInput.sendKeys(category);
		return this;
	}
	
	public EditProjectPage addCategory() {
		addCategoryBtn.click();
		return this;
	}
	
	public String getProjectCategory() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectCategory.getText();
	}
	
	public EditProjectPage setProjectStatus(String status) {
		new Select(projectStatus).selectByVisibleText(status);
		return this;
	}
	
	public EditProjectPage setDescription(String descr) {
		description.clear();
		description.sendKeys(descr);
		return this;
	}
	
	public ManageProjectPage updateProject() {
		updateProjectBtn.click();
		return new ManageProjectPage(driver);
	}
	
	public EditCategoryPage editCategory() {
		editCategoryBtn.click();
		return new EditCategoryPage(driver);
	}
	
	public DeleteProjectConfirmPage deleteProject() {
		deleteProjectBtn.click();
		return new DeleteProjectConfirmPage(driver);
	}
	
	public String getError() {
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]")).getText();
	}
	
	public EditProjectPage setViewState(String state) {
		new Select(viewState).selectByVisibleText(state);
		return this;
	}
	
	public EditProjectPage deleteCategory() {
		deleteCategoryBtn.click();
		return new EditProjectPage(driver);
	}
	
	public EditProjectPage confirmDeleteCategory() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/form/input[5]")).click();
		driver.findElement(By.linkText(Strings.contin)).click();
		return new EditProjectPage(driver);
	}
	
	public boolean containsCategory(String category) {
		return driver.findElement(By.id("categories")).getText().contains(category);
	}
	
	public CreateSubprojectPage createSubproject() {
		createSubprojectBtn.click();
		return new CreateSubprojectPage(driver);
	}
	
	public EditProjectPage unlinkSubproject() {
		unlinkFirstSubproject.click();
		driver.findElement(By.linkText(Strings.contin)).click();
		return new EditProjectPage(driver);
	}
	
	public boolean isSubprojectPresent(String project) {
		try {
			return driver.findElement(By.id("manage-project-update-subprojects-form")).getText().contains(project);
		} catch(NoSuchElementException e) {
			return false;
		}
	}
	
	public EditProjectPage selectSubproject(String project) {
		new Select(driver.findElement(By.name("subproject_id"))).selectByVisibleText(project);
		return this;
	}
	
	public EditProjectPage linkSubproject() {
		linkSubprojectBtn.click();
		driver.findElement(By.linkText(Strings.contin)).click();
		return new EditProjectPage(driver);
	}
	
	
	
	

}
