package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends AdminSidebar {
	
	@FindBy(xpath = "/html/body/div[2]/div/main/div[3]/ul/li[2]/button")
	protected WebElement deleteFirstProdBtn;

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstProductName() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return driver.findElement(By.xpath("//*[@id=\"container\"]/div/main/div[3]/ul/li[2]/div/a")).getText();
	}
	
	public EditProductPage goToProduct(String product) {
		driver.findElement(By.linkText(product)).click();
		return new EditProductPage(driver);
	}
	
	public ProductsPage deleteFirstProduct() {
		deleteFirstProdBtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public boolean containsProduct(String product) {
		return driver.findElement(By.xpath("/html/body/div[2]/div/main/div[3]/ul/li[2]/div/a")).getText().contains(product);
	}

}
