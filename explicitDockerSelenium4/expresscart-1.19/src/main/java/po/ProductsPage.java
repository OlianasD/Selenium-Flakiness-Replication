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
	}
	
	public String getFirstProductName() {
		return wait.waitVisibility(By.xpath("//*[@id=\"container\"]/div/main/div[3]/ul/li[2]/div/a")).getText();
	}
	
	public EditProductPage goToProduct(String product) {
		wait.waitClickability(By.linkText(product)).click();
		return new EditProductPage(driver);
	}
	
	public ProductsPage deleteFirstProduct() {
		wait.waitClickability(deleteFirstProdBtn);
		deleteFirstProdBtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public boolean containsProduct(String product) {
		return wait.waitVisibility(By.xpath("/html/body/div[2]/div/main/div[3]/ul/li[2]/div/a")).getText().contains(product);
	}

}
