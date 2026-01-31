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
	
	@FindBy(xpath = "//*[@id=\"discountNewForm\"]/div[1]/div/div/button")
	protected WebElement addDiscount;
	
	@FindBy(xpath = "//*[@id=\"discountNewForm\"]/div[2]/div")
	protected WebElement discountCodeError;
	
	@FindBy(xpath = "//*[@id=\"discountNewForm\"]/div[4]/div")
	protected WebElement discountValueError;

	public NewDiscountPage(WebDriver driver) {
		super(driver);
	}
	
	public NewDiscountPage setCode(String code) {
		wait.waitClickability(discountCode);
		discountCode.sendKeys(code);
		return this;
	}
	
	public NewDiscountPage setValue(String value) {
		wait.waitClickability(discountValue);
		discountValue.sendKeys(value);
		return this;
	}
	
	public NewDiscountPage setStart(String start) {
		wait.waitClickability(By.id("discountStart")).sendKeys(start);
		wait.waitClickability(By.xpath("/html/body/div[10]/div/div[3]/button[1]")).click();
		return this;
	}
	
	public NewDiscountPage setEnd(String end) {
		wait.waitClickability(By.id("discountEnd")).sendKeys(end);
		wait.waitClickability(By.xpath("/html/body/div[11]/div/div[3]/button[1]")).click();
		return this;
	}
	
	public NewDiscountPage setType(String type) {
		new Select(wait.waitClickability(By.id("discountType"))).selectByVisibleText(type);
		return this;
	}
	
	public AdminSidebar addDiscount() {
		wait.waitClickability(addDiscount);
		addDiscount.click();
		return new AdminSidebar(driver);
	}
	
	public NewDiscountPage addDiscountError() {
		wait.waitClickability(addDiscount);
		addDiscount.click();
		return new NewDiscountPage(driver);
	}
	
	public boolean discountCodeHasError() {
		wait.waitVisibility(discountCodeError);
		return discountCodeError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean discountValueHasError() {
		wait.waitVisibility(discountValueError);
		return discountValueError.getAttribute("class").contains("has-error has-danger");
	}
	
	
	
	
	
	

}
