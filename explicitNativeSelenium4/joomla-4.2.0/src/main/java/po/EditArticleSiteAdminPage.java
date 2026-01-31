package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class EditArticleSiteAdminPage extends PageObject {
	
	@FindBy(className = "button-save")
	protected WebElement saveBtn;

	protected Wait wait;
	public EditArticleSiteAdminPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public EditArticleSiteAdminPage selectCategory(String cat) {
		wait.waitClickability(By.xpath("//*[@id=\"general\"]/div/div[2]/fieldset/div[2]/div[2]/joomla-field-fancy-select/div/div[1]")).click();
		wait.waitClickability(By.xpath("/html/body/div[1]/div/section/div/div/main/form/div[2]/joomla-tab/joomla-tab-element[1]/div/div[2]/fieldset/div[2]/div[2]/joomla-field-fancy-select/div/div[2]/input")).sendKeys(cat);
		wait.waitClickability(By.xpath("/html/body/div[1]/div/section/div/div/main/form/div[2]/joomla-tab/joomla-tab-element[1]/div/div[2]/fieldset/div[2]/div[2]/joomla-field-fancy-select/div/div[2]/input")).sendKeys(Keys.ENTER);
		return this;
	}
	
	public ManageArticlesPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new ManageArticlesPage(driver);
	}

}
