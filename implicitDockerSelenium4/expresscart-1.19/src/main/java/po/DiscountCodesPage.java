package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.XpathGenerator;

public class DiscountCodesPage extends AdminSidebar {
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/main/div/h2/div/a")
	protected WebElement newDiscountBtn;

	public DiscountCodesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public NewDiscountPage newDiscount() {
		newDiscountBtn.click();
		return new NewDiscountPage(driver);
	}
	
	public String getIthDiscountCode(int i) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return driver.findElement(By.xpath("//*[@id=\"container\"]/div/main/div/ul/li["+i+"]/div/div[1]/span")).getText();
	}
	
	public DiscountCodesPage deleteDiscountCode(String code) {
		XpathGenerator xpgen = new XpathGenerator();
		WebElement codeElem = driver.findElement(By.xpath("//*[contains(text(), '"+code+"')]"));
		String codeXpath = xpgen.generateXpath(codeElem, "");
		codeXpath = codeXpath.replace("div[1]/span[1]", "div[4]/button");
		driver.findElement(By.xpath(codeXpath)).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public boolean containsCode(String code) {
		return driver.findElement(By.xpath("//*[@id=\"container\"]/div/main/div/ul")).getText().contains("Code:  "+code);
	}
}
