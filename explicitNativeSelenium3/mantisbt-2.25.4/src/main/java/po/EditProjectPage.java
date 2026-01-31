package po;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Strings;
import utils.Wait;

public class EditProjectPage extends CreateProjectPage {
	
	@FindBy(xpath = "//*[@id=\"project-add-category-form\"]/fieldset/input[3]")
	protected WebElement categoryInput;
	
	@FindBy(xpath = "//*[@id=\"project-add-category-form\"]/fieldset/input[4]")
	protected WebElement addCategoryBtn;
	
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
	
	protected Wait wait;

	public EditProjectPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public EditProjectPage enterCategory(String category) {
		wait.waitClickability(categoryInput);
		categoryInput.clear();
		categoryInput.sendKeys(category);
		return this;
	}
	
	public EditProjectPage addCategory() {
		wait.waitClickability(addCategoryBtn);
		addCategoryBtn.click();
		return this;
	}
	
	public String getProjectCategory() {
		/*try {
			return wait.waitVisibilityRefreshed(By.xpath("//*[@id=\"categories\"]/div/div[3]/div/div/table/tbody/tr[1]/td[1]")).getText();
		} catch(WebDriverException e) {
			return wait.waitVisibilityRefreshed(By.xpath("//*[@id=\"categories\"]/div/div[3]/div/div/table/tbody/tr[1]/td[1]")).getText();
		}*/
		return wait.waitVisibilityRefreshed(By.xpath("//*[@id=\"categories\"]/div/div[3]/div/div/table/tbody/tr[1]/td[1]")).getText();
	}
	
	public EditProjectPage setProjectStatus(String status) {
		wait.waitClickability(projectStatus);
		new Select(projectStatus).selectByVisibleText(status);
		return this;
	}
	
	public EditProjectPage setDescription(String descr) {
		wait.waitClickability(description);
		description.clear();
		description.sendKeys(descr);
		return this;
	}
	
	public ManageProjectPage updateProject() {
		wait.waitClickability(updateProjectBtn);
		updateProjectBtn.click();
		return new ManageProjectPage(driver);
	}
	
	public EditCategoryPage editCategory() {
		wait.waitClickability(editCategoryBtn);
		editCategoryBtn.click();
		return new EditCategoryPage(driver);
	}
	
	public DeleteProjectConfirmPage deleteProject() {
		wait.waitClickability(deleteProjectBtn);
		deleteProjectBtn.click();
		return new DeleteProjectConfirmPage(driver);
	}
	
	public String getError() {
		wait.waitVisibility(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]"));
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]")).getText();
	}
	
	public EditProjectPage setViewState(String state) {
		wait.waitClickability(viewState);
		new Select(viewState).selectByVisibleText(state);
		return this;
	}
	
	public EditProjectPage deleteCategory() {
		wait.waitClickability(deleteCategoryBtn);
		deleteCategoryBtn.click();
		return new EditProjectPage(driver);
	}
	
	public EditProjectPage confirmDeleteCategory() {
		wait.waitClickability(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/form/input[5]"));
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/form/input[5]")).click();
		wait.waitClickability(By.linkText(Strings.contin));
		driver.findElement(By.linkText(Strings.contin)).click();
		return new EditProjectPage(driver);
	}
	
	public boolean containsCategory(String category) {
		wait.waitVisibility(By.id("categories"));
		return driver.findElement(By.id("categories")).getText().contains(category);
	}
	
	public CreateSubprojectPage createSubproject() {
		wait.waitClickability(createSubprojectBtn);
		createSubprojectBtn.click();
		return new CreateSubprojectPage(driver);
	}
	
	public EditProjectPage unlinkSubproject() {
		wait.waitClickability(unlinkFirstSubproject);
		unlinkFirstSubproject.click();
		wait.waitClickability(By.linkText(Strings.contin));
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
		wait.waitClickability(By.name("subproject_id"));
		new Select(driver.findElement(By.name("subproject_id"))).selectByVisibleText(project);
		return this;
	}
	
	public EditProjectPage linkSubproject() {
		wait.waitClickability(linkSubprojectBtn);
		linkSubprojectBtn.click();
		wait.waitClickability(By.linkText(Strings.contin));
		driver.findElement(By.linkText(Strings.contin)).click();
		return new EditProjectPage(driver);
	}
	
	
	
	

}
