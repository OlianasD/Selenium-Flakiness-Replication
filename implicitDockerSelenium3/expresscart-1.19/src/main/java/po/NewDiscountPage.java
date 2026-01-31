package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewDiscountPage extends AdminSidebar {
	
	@FindBy(id = "discountCode")
	protected WebElement discountCode;
	
	@FindBy(id = "discountValue")
	protected WebElement discountValue;
	
	@FindBy(id = "discountStart")
	protected WebElement discountStart;
	
	@FindBy(id = "discountEnd")
	protected WebElement discountEnd;
	
	@FindBy(xpath = "//*[@id=\"discountNewForm\"]/div[1]/div/div/button")
	protected WebElement addDiscount;
	
	@FindBy(xpath = "//*[@id=\"discountNewForm\"]/div[2]/div")
	protected WebElement discountCodeError;
	
	@FindBy(xpath = "//*[@id=\"discountNewForm\"]/div[4]/div")
	protected WebElement discountValueError;
	
	

	public NewDiscountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public NewDiscountPage setCode(String code) {
		discountCode.sendKeys(code);
		return this;
	}
	
	public NewDiscountPage setValue(String value) {
		discountValue.sendKeys(value);
		return this;
	}
	
	public NewDiscountPage setStart(String start) {
		driver.findElement(By.id("discountStart")).sendKeys(start);
		driver.findElement(By.xpath("/html/body/div[10]/div/div[3]/button[1]")).click();
		return this;
	}
	
	public NewDiscountPage setEnd(String end) {
		driver.findElement(By.id("discountEnd")).sendKeys(end);
		driver.findElement(By.xpath("/html/body/div[11]/div/div[3]/button[1]")).click();
		return this;
	}
	
	public NewDiscountPage setType(String type) {
		new Select(driver.findElement(By.id("discountType"))).selectByVisibleText(type);
		return this;
	}
	
	public AdminSidebar addDiscount() {
		addDiscount.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return new AdminSidebar(driver);
	}
	
	public NewDiscountPage addDiscountError() {
		addDiscount.click();
		return new NewDiscountPage(driver);
	}
	
	public boolean discountCodeHasError() {
		return discountCodeError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean discountValueHasError() {
		return discountValueError.getAttribute("class").contains("has-error has-danger");
	}
	
	
	
	
	
	

}
