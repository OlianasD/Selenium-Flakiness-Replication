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
	
	@FindBy(xpath = "//*[@id=\"productNewForm\"]/div[3]/div[1]/div")
	protected WebElement productPriceError;

	public NewProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public NewProductPage setTitle(String title) {
		productTitle.sendKeys(title);
		return this;
	}
	
	public NewProductPage setPrice(String price) {
		productPrice.sendKeys(price);
		return this;
	}
	
	public NewProductPage setDescr(String descr) {
		productDescr.sendKeys(descr);
		return this;
	}
	
	public AdminSidebar addProduct() {
		saveBtn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return new AdminSidebar(driver);
	}
	
	public NewProductPage addProductError() {
		saveBtn.click();
		return new NewProductPage(driver);
	}
	
	
	public boolean productTitleHasError() {
		return productTitleError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean productPriceHasError() {
		return productTitleError.getAttribute("class").contains("has-error has-danger");
	}

}
