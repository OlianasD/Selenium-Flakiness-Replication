package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class CreateCategoryPage extends PageObject {
	
	@FindBy(id = "jform_title")
	protected WebElement title;
	
	@FindBy(className = "button-save")
	protected WebElement saveBtn;
	
	@FindBy(xpath = "//*[@id=\"jform_title-lbl\"]/span[2]")
	protected WebElement emptyTitleAlert;

	protected Wait wait;
	
	public CreateCategoryPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public CreateCategoryPage setTitle(String ttl) {
		wait.waitClickability(title);
		title.clear();
		title.sendKeys(ttl);
		return this;
	}
	
	public ManageCategoriesPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new ManageCategoriesPage(driver);
	}
	
	public CreateCategoryPage saveError() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new CreateCategoryPage(driver);
	}
	
	public String getEmptyTitleAlert() {
		wait.waitVisibility(emptyTitleAlert);
		return emptyTitleAlert.getText();
	}

}
