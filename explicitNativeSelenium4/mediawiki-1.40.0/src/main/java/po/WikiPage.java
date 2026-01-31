package po;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class WikiPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"firstHeading\"]")
	protected WebElement title;
	
	@FindBy(xpath = "//*[@id=\"mw-content-text\"]")
	protected WebElement body;

	@FindBy(linkText = "Create source")
	protected WebElement createSource;
	
	@FindBy(xpath = "//*[@id=\"mw-normal-catlinks\"]/ul/li/a")
	protected WebElement category;
	
	//@FindBy(id = "p-cactions-checkbox")
	/*@FindBy(xpath = "//*[@id=\"p-cactions-checkbox\"]")
	protected WebElement more;*/
	
	protected Wait wait;

	public WikiPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}

	public boolean waitFotTitleToBe(String expected) {
		return wait.waitForTextToBe(By.id("firstHeading"), expected);
	}

	public boolean waitForTitleToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"firstHeading\"]"), expected);
	}
	
	public String getBody(String expected) {
		wait.waitForTextToBeContained(By.xpath("//*[@id=\"mw-content-text\"]"), expected);
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]")).getText();
	}
	
	public PageCreationPage edit() {
		wait.waitClickability(By.linkText("Edit")).click();
		return new PageCreationPage(driver);
	}
	
	public EditSourcePage editSource() {
		wait.waitClickabilityRefreshed(By.linkText("Edit source")).click();
		return new EditSourcePage(driver);
	}
	
	public EditSourcePage createSource() {
		createSource.click();
		return new EditSourcePage(driver);
	}
	
	public WikiPage goToLink(String link) {
		By locator = By.linkText(link);
		wait.waitStaleness(driver.findElement(locator));
		wait.waitClickability(locator).click();
		return new WikiPage(driver);
	}
	
	public String getCategory() {
		wait.waitVisibility(category);
		return category.getText();
	}
	
	public PageProtectPage protect() {
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		more.click();*/
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).build().perform();
		/*try {
			action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).build().perform();
		} catch(StaleElementReferenceException | NoSuchElementException e) {
			action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).build().perform();
		}*/
		/*By locator = By.linkText("Protect");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		wait.waitClickability(locator);*/
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}*/
		wait.waitClickability(By.linkText("Protect")).click();
		return new PageProtectPage(driver);
	}
	
	public PageProtectPage changeProtectionLevel() {
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.waitClickability(By.xpath("//*[@id=\"p-cactions-checkbox\"]")).click();*/
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).click().build().perform();
		/*try {
			action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).click().build().perform();
		} catch(WebDriverException e) {
			System.out.println("!! WebDriver exception caught in WikiPage.changeProtectionLevel");
			action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).click().build().perform();
		}*/
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		wait.waitClickability(By.xpath("//*[@id=\"ca-unprotect\"]/a")).click();
		return new PageProtectPage(driver);
	}
	
	public PageCreationPage forceEdit() {
		driver.get(driver.getCurrentUrl()+"?veaction=edit");
		return new PageCreationPage(driver);
	}
	
	public RevisionHistoryPage viewHistory() {
		wait.waitClickabilityRefreshed(By.linkText("View history")).click();
		return new RevisionHistoryPage(driver);
	}
	
	public DeletePage deletePage() {
		//wait.waitClickability(By.xpath("//*[@id=\"p-cactions-checkbox\"]")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).click().build().perform();
		/*try {
			action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).click().build().perform();
		} catch(WebDriverException e) {
			System.out.println("!! WebDriver exception caught in WikiPage.deletePage");
			action.moveToElement(driver.findElement(By.id("p-cactions-checkbox"))).click().build().perform();
		}*/
		By locator = By.linkText("Delete");
		wait.waitClickability(locator);
		driver.findElement(locator).click();
		return new DeletePage(driver);
	}
	
	public String getMainRedirect() {
		return wait.waitVisibility(By.className("redirectText")).getText();
	}
	
	public String getSourceRedirect() {
		return driver.findElement(By.className("mw-redirectedfrom")).getText();
	}

	public MainPage goHome(String appUrl) {
		driver.get(appUrl);
		return new MainPage(driver);
	}

}
