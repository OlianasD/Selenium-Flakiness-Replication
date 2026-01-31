package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProductPage extends AdminSidebar {
	
	@FindBy(id = "productTags-tokenfield")
	protected WebElement tagField;
	
	@FindBy(id = "productUpdate")
	protected WebElement updateProductBtn;

	public EditProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public EditProductPage setTag(String tag) {
		tagField.sendKeys(tag+",");
		return this;
	}
	
	public String getLastTag() {
		return driver.findElement(By.xpath("//*[@id=\"productEditForm\"]/div/div[9]/div/div/div/span")).getText();
	}
	
	
	public EditProductPage saveProduct() {
		updateProductBtn.click();
		return this;
	}
	
	public EditProductPage deleteTag() {
		driver.findElement(By.xpath("//*[@id=\"productEditForm\"]/div/div[9]/div/div/div/a")).click();
		return this;
	}
	
	public boolean productHasNoTags() {
		return driver.findElement(By.id("productTags-tokenfield")).getAttribute("value").equals("");
	}
	

}
