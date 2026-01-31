package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class AddCategoryPage extends PageObject {
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/fieldset[1]/div/div/div/div/div/div[1]/div/input")
	public WebElement addCategoryInput;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div[1]/div[2]/div[1]/div/div[1]/span")
	public WebElement applyBtn;
	
	protected Wait wait;

	public AddCategoryPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public AddCategoryPage addCategory(String cat) {
		wait.waitClickability(addCategoryInput);
		addCategoryInput.sendKeys(cat);
		wait.waitAttributeToBeNotEmpty(addCategoryInput, "aria-activedescendant");
		addCategoryInput.sendKeys(Keys.ENTER);
		return this;
	}
	
	public String getCategoryName() {
		return driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/fieldset[1]/div/div/div/div/div/div[1]/span/a/span[2]")).getText();
	}
	
	public PageCreationPage applyChanges() {
		applyBtn.click();
		return new PageCreationPage(driver);
	}
	
	

}
