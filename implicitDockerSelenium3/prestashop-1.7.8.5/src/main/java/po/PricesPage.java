package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricesPage extends AdminSidebar {
	
	@FindBy(id = "form_step2_price")
    protected WebElement preTaxRetail;
	
	@FindBy(id = "priceTI")
	protected WebElement retailPriceWithTax;
	
	@FindBy(id = "final_retail_price_ti")
	protected WebElement finalPrice;
	
	@FindBy(id = "/html/body/span[4]/span/span[1]/input")
    protected WebElement taxRules;
	
	@FindBy(xpath = "//*[@id=\"step2\"]/div/div/div/div/div[3]/div/div[1]/span")
	protected WebElement taxOuterSelector;

	public PricesPage(WebDriver driver) {
		super(driver);
	}
	
	public PricesPage setPretaxRetail(String pretaxPrice) {
		preTaxRetail.clear();
    	preTaxRetail.sendKeys(pretaxPrice);
    	return new PricesPage(driver);
	}
	
	public PricesPage chooseTaxRules10() {
		taxOuterSelector.click();
		driver.findElement(By.xpath("/html/body/span[4]/span/span[1]/input")).sendKeys("IT Reduced Rate (10%)");
		driver.findElement(By.xpath("/html/body/span[4]/span/span[1]/input")).sendKeys(Keys.ENTER);
		return this;
    }
	
	public PricesPage chooseTaxRules22() {
		taxOuterSelector.click();
		driver.findElement(By.xpath("/html/body/span[4]/span/span[1]/input")).sendKeys("IT Standard Rate (22%)");
		driver.findElement(By.xpath("/html/body/span[4]/span/span[1]/input")).sendKeys(Keys.ENTER);
		return this;
	}
	
	public String getRetailPriceWithTax() {
		return retailPriceWithTax.getText();
	}
	
	public String getFinalPrice() {
		return finalPrice.getText();
	}

}
