package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewContentPage extends AdminSidebar {
	
	@FindBy(id = "jstitle")
	protected WebElement title;
	
	@FindBy(id =  "jsbuttonSave")
	protected WebElement saveBtn;
	
	@FindBy(id = "jsoptionsSidebar")
	protected WebElement optionsBtn;
	
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
	
	
	public NewContentPage(WebDriver driver) {
		super(driver);
	}
	
	public NewContentPage setTitle(String ttl) {
		title.sendKeys(ttl);
		return this;
	}
	
	public ContentPage saveAndReturnToContentPage() {
		saveBtn.click();
		return new ContentPage(driver);
	}
	
	public NewContentPage saveAndStay() {
		saveBtn.click();
		return new NewContentPage(driver);
	}
	
	public NewContentPage options() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		optionsBtn.click();
		return this;
	}
	
	public NewContentPage seo() {
		seoTab.click();
		return this;
	}
	
	public NewContentPage advanced() {
		advancedTab.click();
		return this;
	}
	
	public NewContentPage setUrl(String url) {
		urlField.clear();
		urlField.sendKeys(url);
		return this;
	}
	
	public NewContentPage setPosition(String pos) {
		positionField.clear();
		positionField.sendKeys(pos);
		return this;
	}
	
	public NewContentPage setDraft() {
		draftBtn.click();
		return this;
	}
	
	public NewContentPage setPostType(String type) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Select(driver.findElement(By.id("jstypeSelector"))).selectByVisibleText(type);
		return this;
	}
	
	public String getPosition() {
		return positionField.getAttribute("value");
	}
	
	public NewContentPage setParent(String parent) {
		driver.findElement(By.xpath("//*[@id=\"nav-advanced\"]/div[5]/span/span[1]/span")).click();
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(parent);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"select2-jsparent-results\"]/li")).click();
		return this;
	}
	
	public String getSelectedParent() {
		return driver.findElement(By.xpath("//*[@id=\"select2-jsparent-container\"]")).getAttribute("title");
	}
	
	public NewContentPage setDate(String date) {
		this.date.clear();
		this.date.sendKeys(date);
		return this;
	}
	
	public String getDate() {
		return date.getAttribute("value");
	}
	
	public NewContentPage setCategory(String category) {
		new Select(driver.findElement(By.id("jscategory"))).selectByVisibleText(category);
		return this;
	}
	
	public String getSelectedCategory() {
		return new Select(driver.findElement(By.id("jscategory"))).getFirstSelectedOption().getText();
	}
	
	

}
