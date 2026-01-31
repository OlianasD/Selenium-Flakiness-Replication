package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AddCategoryPage(driver);
	}

	public String getAlertMessage() {
		return alertMsg.getText();
	}
}
