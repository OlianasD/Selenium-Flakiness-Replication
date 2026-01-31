package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProductPage extends AdminSidebar {
	
	@FindBy(id = "productTitle")
	protected WebElement productTitle;
	
	@FindBy(id = "productPrice")
	protected WebElement productPrice;
	
	@FindBy(xpath = "//*[@id=\"editor-wrapper\"]/div/div[3]/div[2]")
	protected WebElement productDescr;
	
	@FindBy(id = "frm_edit_product_save")
	protected WebElement saveBtn;
	
	@FindBy(xpath = "//*[@id=\"productNewForm\"]/div[2]/div")
	protected WebElement productTitleError;


	public NewProductPage(WebDriver driver) {
		super(driver);
	}
	
	public NewProductPage setTitle(String title) {
		wait.waitClickability(productTitle);
		productTitle.sendKeys(title);
		return this;
	}
	
	public NewProductPage setPrice(String price) {
		wait.waitClickability(productPrice);
		productPrice.sendKeys(price);
		return this;
	}
	
	public NewProductPage setDescr(String descr) {
		wait.waitClickability(productDescr);
		productDescr.sendKeys(descr);
		return this;
	}
	
	public AdminSidebar addProduct() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new AdminSidebar(driver);
	}
	
	public NewProductPage addProductError() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new NewProductPage(driver);
	}
	
	
	public boolean productTitleHasError() {
		wait.waitVisibility(productTitleError);
		return productTitleError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean productPriceHasError() {
		wait.waitVisibility(productTitleError);
		return productTitleError.getAttribute("class").contains("has-error has-danger");
	}

}
