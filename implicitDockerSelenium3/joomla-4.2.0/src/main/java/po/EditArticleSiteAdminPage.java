package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditArticleSiteAdminPage extends PageObject {
	
	@FindBy(className = "button-save")
	protected WebElement saveBtn;
	
	public EditArticleSiteAdminPage(WebDriver driver) {
		super(driver);
	}
	
	public EditArticleSiteAdminPage selectCategory(String cat) {
		driver.findElement(By.xpath("//*[@id=\"general\"]/div/div[2]/fieldset/div[2]/div[2]/joomla-field-fancy-select/div/div[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/main/form/div[2]/joomla-tab/joomla-tab-element[1]/div/div[2]/fieldset/div[2]/div[2]/joomla-field-fancy-select/div/div[2]/input")).sendKeys(cat);
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/main/form/div[2]/joomla-tab/joomla-tab-element[1]/div/div[2]/fieldset/div[2]/div[2]/joomla-field-fancy-select/div/div[2]/input")).sendKeys(Keys.ENTER);
		return this;
	}
	
	public ManageArticlesPage save() {
		saveBtn.click();
		return new ManageArticlesPage(driver);
	}

}
