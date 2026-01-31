package po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.JavascriptExecutor;
import utils.Wait;

public class ManageFieldsPage extends SiteAdminPageObject {
	
	@FindBy(xpath = "//*[@id=\"toolbar-new\"]/button")
	protected WebElement createFieldBtn;
	
	@FindBy(xpath = "//*[@id=\"toolbar-status-group\"]/button")
	protected WebElement actionsBtn;
	
	public ManageFieldsPage(WebDriver driver) {
		super(driver);
	}
	
	public EditFieldPage createField() {
		wait.waitClickability(createFieldBtn);
		createFieldBtn.click();
		return new EditFieldPage(driver);
	}
	
	public boolean isFieldPresent(String field) {
		try {
			wait.waitForTextToBeContained(By.id("fieldList"), field);
			return driver.findElement(By.id("fieldList")).getText().contains(field);
		} catch(NoSuchElementException e) {
			if(driver.findElement(By.xpath("//*[@id=\"j-main-container\"]/div[2]")).getText().contains("No Matching Results")) {
				return false;
			}
			else {
				throw e;
			}
			
		}
	}

	public boolean noFieldsPresent() {
		return wait.waitForTextToBeContained(By.xpath("//*[@id=\"j-main-container\"]/div[2]"), "No Matching Results");
	}
	
	public EditFieldPage goToField(String field) {
		WebElement fLink = driver.findElement(By.linkText(field));
		new JavascriptExecutor(driver).scrollTo(fLink);
		wait.waitClickability(fLink);
		fLink.click();
		return new EditFieldPage(driver);
	}
	
	public boolean fieldHasGroup(int field, String group) {
		wait.waitForTextToBeContained(By.xpath("//*[@id=\"fieldList\"]/tbody/tr["+field+"]/td[5]"), group);
		return driver.findElement(By.xpath("//*[@id=\"fieldList\"]/tbody/tr["+field+"]/td[5]")).getText().contains(group);
	}
	
	public ManageFieldsPage selectIthField(int i) {
		wait.waitClickability(By.xpath("/html/body/div[1]/div[2]/section/div/div/main/form/div/div/div/table/tbody/tr["+i+"]/td[1]/input")).click();
		return this;
	}
	
	public ManageFieldsPage deleteSelectedField() {
		wait.waitClickability(actionsBtn);
		actionsBtn.click();
		wait.waitClickability(By.xpath("//*[@id=\"status-group-children-trash\"]/button")).click();
		return new ManageFieldsPage(driver);
		
	}

}
