package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class AddCategoryPage {
	WebDriver driver;
	@FindBy(id = "page-header-desc-category-new_category")
	WebElement addCategory;
	@FindBy(id = "category_name_1")
	WebElement name_1;
	@FindBy(id = "save-button")
	WebElement submitCategory;
	@FindBy(xpath = "//*[@id=\"main-div\"]/div/div/div/div[2]/div/form/div/div[1]/div/div[1]/div/div[2]/div[2]/div")
	WebElement alertMsg;

	Wait wait;

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	public void clickAddCategory() {
		addCategory.click();
	}

	public CategoriesPage submitCategory(String nameStr) {
		name_1.clear();
		name_1.sendKeys(nameStr);
		submitCategory.click();
		return new CategoriesPage(driver);
	}

	public AddCategoryPage submitEmptyCategory() {
		submitCategory.click();
		return new AddCategoryPage(driver);
	}

	public String getAlertMessage() {
		wait.waitVisibility(alertMsg);
		return alertMsg.getText();
	}

	public boolean waitForAlertTextToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"main-div\"]/div/div/div/div[2]/div/form/div/div[1]/div/div[1]/div/div[2]/div[2]/div"), expected);
	}
}
