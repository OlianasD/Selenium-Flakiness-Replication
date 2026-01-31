package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ProductsPage extends AdminSidebar {
	
	@FindBy(id = "page-header-desc-configuration-add")
    protected WebElement addNewProduct;
	
	@FindBy(className = "alert-success")
	protected WebElement tagMessage;
	
	@FindBy(xpath = "//*[@id=\"product_catalog_list\"]/div[2]/div/div/table/tbody/tr/td[11]/div/div/a")
	protected WebElement editProduct;
	
	@FindBy(xpath = "//*[@id=\"product_catalog_list\"]/div[2]/div/div/table/tbody/tr/td[4]/a")
	protected WebElement firstProduct;
	
	protected Wait wait;

	public ProductsPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public AddProductPage addNewProduct() {
		addNewProduct.click();
		return new AddProductPage(driver);
	}
	
	public String getSuccessMessage() {
		return tagMessage.getText();
	}
	
	public AddProductPage editProduct() {
		editProduct.click();
		return new AddProductPage(driver);
	}
	
	public String getFirstProductName() {
		wait.waitVisibility(firstProduct);
		return firstProduct.getText();
	}

	public boolean waitForFirstProductToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"product_catalog_list\"]/div[2]/div/div/table/tbody/tr/td[4]/a"), expected);
	}

}
