package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class TopNavBar extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[1]/a")
	protected WebElement accountBtn;

	@FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[2]/a")
	protected WebElement cartBtn;
	
	@FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li/a")
	protected WebElement loggedCartBtn;

	@FindBy(id = "cart-count")
	protected WebElement cartCount;

	protected Wait wait;

	public TopNavBar(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public int getCartCount(String expected) {
		wait.waitForTextToBe(By.id("cart-count"), expected);
		return Integer.parseInt(cartCount.getText());
	}
	
	public CartSidebar openCart() {
		wait.waitClickability(cartBtn);
		cartBtn.click();
		return new CartSidebar(driver);
	}
	
	public CartSidebar openCartLogged() {
		wait.waitClickability(loggedCartBtn);
		loggedCartBtn.click();
		return new CartSidebar(driver);
	}
	
	public CustomerLoginPage account() {
		wait.waitClickability(accountBtn);
		accountBtn.click();
		return new CustomerLoginPage(driver);
	}

}
