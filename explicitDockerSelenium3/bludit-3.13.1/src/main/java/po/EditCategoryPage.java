package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class EditCategoryPage extends NewCategoryPage {
	
	@FindBy(id = "jsnewKey")
	protected WebElement url;
	
	@FindBy(xpath = "//*[@id=\"jsform\"]/div[1]/div/button[2]")
	protected WebElement deleteBtn;
	
	@FindBy(xpath = "//*[@id=\"jsdeleteModal\"]/div/div/div[2]/button[2]")
	protected WebElement confirmDeleteBtn;
	
	public EditCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	public EditCategoryPage setUrl(String url) {
		wait.waitClickability(this.url);
		this.url.clear();
		this.url.sendKeys(url);
		return this;
	}
	
	public EditCategoryPage delete() {
		wait.waitClickability(deleteBtn);
		deleteBtn.click();
		return new EditCategoryPage(driver);
	}
	
	public CategoriesPage confirmDelete() {
		wait.waitClickability(confirmDeleteBtn);
		confirmDeleteBtn.click();
		return new CategoriesPage(driver);
	}
	
	

}
