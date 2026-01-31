package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Wait;

public class NewContentPage extends AdminSidebar {
	
	@FindBy(id = "jstitle")
	protected WebElement title;
	
	@FindBy(id =  "jsbuttonSave")
	protected WebElement saveBtn;
	
	@FindBy(id = "nav-seo-tab")
	protected WebElement seoTab;
	
	@FindBy(id = "nav-advanced-tab")
	protected WebElement advancedTab;
	
	@FindBy(id = "jsslug")
	protected WebElement urlField;
	
	@FindBy(id = "jsposition")
	protected WebElement positionField;
	
	@FindBy(id = "jsbuttonSwitch")
	protected WebElement draftBtn;
	
	@FindBy(id ="jsdate")
	protected WebElement date;
	
	@FindBy(xpath = "//*[@id=\"nav-advanced\"]/div[5]/span/span[1]/span")
	protected WebElement parentOuterSelect;
	
	@FindBy(xpath = "/html/body/span/span/span[1]/input")
	protected WebElement parentSearchField;
	
	@FindBy(xpath = "//*[@id=\"select2-jsparent-results\"]/li")
	protected WebElement parentActualItem;

	@FindBy(id = "jstypeSelector")
	protected WebElement selectPostType;
	
	protected Wait wait;
	
	
	public NewContentPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public NewContentPage setTitle(String ttl) {
		wait.waitClickability(title);
		title.sendKeys(ttl);
		return this;
	}
	
	public ContentPage saveAndReturnToContentPage() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new ContentPage(driver);
	}
	
	public NewContentPage saveAndStay() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new NewContentPage(driver);
	}
	
	public NewContentPage options() {
		WebElement optionsSidebar = wait.waitClickability(By.id("jsoptionsSidebar"));
		optionsSidebar.click();
		return this;
	}
	
	public NewContentPage seo() {
		wait.waitClickability(seoTab);
		seoTab.click();
		return this;
	}
	
	public NewContentPage advanced() {
		wait.waitClickability(advancedTab);
		advancedTab.click();
		return this;
	}
	
	public NewContentPage setUrl(String url) {
		wait.waitClickability(urlField);
		urlField.clear();
		urlField.sendKeys(url);
		return this;
	}
	
	public NewContentPage setPosition(String pos) {
		wait.waitClickability(positionField);
		positionField.clear();
		positionField.sendKeys(pos);
		return this;
	}
	
	public NewContentPage setDraft() {
		wait.waitClickability(draftBtn);
		draftBtn.click();
		return this;
	}
	
	public NewContentPage setPostType(String type) {
		wait.waitClickability(selectPostType);
		new Select(selectPostType).selectByVisibleText(type);
		return this;
	}
	
	public String getPosition() {
		wait.waitVisibility(positionField);
		return positionField.getAttribute("value");
	}
	
	public NewContentPage setParent(String parent) {
		wait.waitClickability(parentOuterSelect);
		parentOuterSelect.click();
		wait.waitClickability(parentSearchField);
		parentSearchField.sendKeys(parent);
		wait.waitForTextToBe(By.xpath("//*[@id=\"select2-jsparent-results\"]/li"), parent);
		parentActualItem.click();
		return this;
	}
	
	public String getSelectedParent() {
		wait.waitVisibility(driver.findElement(By.xpath("//*[@id=\"select2-jsparent-container\"]")));
		return driver.findElement(By.xpath("//*[@id=\"select2-jsparent-container\"]")).getAttribute("title");
	}
	
	public NewContentPage setDate(String dateStr) {
		wait.waitClickability(date);
		date.clear();
		date.sendKeys(dateStr);
		return this;
	}
	
	public String getDate() {
		wait.waitVisibility(date);
		return date.getAttribute("value");
	}
	
	public NewContentPage setCategory(String category) {
		wait.waitClickability(driver.findElement(By.id("jscategory")));
		new Select(driver.findElement(By.id("jscategory"))).selectByVisibleText(category);
		return this;
	}
	
	public String getSelectedCategory() {
		wait.waitVisibility(driver.findElement(By.id("jscategory")));
		return new Select(driver.findElement(By.id("jscategory"))).getFirstSelectedOption().getText();
	}
	
	

}
