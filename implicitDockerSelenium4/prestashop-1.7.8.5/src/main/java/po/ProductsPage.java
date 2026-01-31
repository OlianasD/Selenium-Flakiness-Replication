package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AdminSidebar {
	
	@FindBy(id = "page-header-desc-configuration-add")
    protected WebElement addNewProduct;
	
	@FindBy(className = "alert-success")
	protected WebElement tagMessage;
	
	@FindBy(xpath = "//*[@id=\"product_catalog_list\"]/div[2]/div/div/table/tbody/tr/td[11]/div/div/a")
	protected WebElement editProduct;
	
	//@FindBy(xpath = "//*[@id=\"product_catalog_list\"]/div[2]/div/div/table/tbody/tr[1]/td[4]/a")
	@FindBy(xpath = "//tr[1]/td[4]/a")
	protected WebElement firstProduct;

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public AddProductPage addNewProduct() {
		addNewProduct.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AddProductPage(driver);
	}
	
	public String getSuccessMessage() {
		return tagMessage.getText();
	}
	
	public AddProductPage editProduct() {
		editProduct.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AddProductPage(driver);
	}
	
	public String getFirstProductName() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return driver.findElement(By.xpath("//*[@id=\"product_catalog_list\"]/div[2]/div/div/table/tbody/tr[1]/td[4]/a")).getText();
	}

}
