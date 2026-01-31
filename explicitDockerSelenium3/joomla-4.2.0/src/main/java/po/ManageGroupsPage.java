package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.JavascriptExecutor;
import utils.Wait;

public class ManageGroupsPage extends SiteAdminPageObject {
	
	@FindBy(xpath ="//*[@id=\"toolbar-new\"]/button")
	protected WebElement newGroupBtn;
	
	@FindBy(xpath = "//*[@id=\"toolbar-delete\"]/button")
	protected WebElement deleteBtn;
	
	public ManageGroupsPage(WebDriver driver) {
		super(driver);
	}
	
	public CreateGroupPage createGroup() {
		wait.waitClickability(newGroupBtn);
		newGroupBtn.click();
		return new CreateGroupPage(driver);
	}
	
	public String getIthGroupName(int i) {
		wait.waitVisibility(By.xpath("//*[@id=\"groupList\"]/tbody/tr["+i+"]/th/a"));
		return driver.findElement(By.xpath("//*[@id=\"groupList\"]/tbody/tr["+i+"]/th/a")).getText();
	}
	
	public ManageGroupsPage selectIthGroup(int i) {
		WebElement selector = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/div/div/main/form/div/div/div/table/tbody/tr["+i+"]/td[1]/input"));
		new JavascriptExecutor(driver).scrollTo(selector);
		wait.waitClickability(selector);
		selector.click();
		return this;
	}
	
	public ManageGroupsPage deleteGroup() {
		wait.waitClickability(deleteBtn);
		deleteBtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return new ManageGroupsPage(driver);
	}
	
	public boolean isGroupPresent(String group) {
		return wait.waitVisibility(By.id("groupList")).getText().contains(group);
	}
	

}
