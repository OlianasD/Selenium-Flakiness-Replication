package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"firstHeading\"]")
	protected WebElement title;
	
	@FindBy(xpath = "//*[@id=\"mw-content-text\"]")
	protected WebElement body;
	
	@FindBy(linkText = "Edit")
	protected WebElement edit;
	
	@FindBy(linkText = "Edit source")
	protected WebElement editSource;
	
	@FindBy(linkText = "Create source")
	protected WebElement createSource;
	
	@FindBy(xpath = "//*[@id=\"mw-normal-catlinks\"]/ul/li/a")
	protected WebElement category;
	
	@FindBy(id = "p-cactions-checkbox")
	protected WebElement more;
	
	@FindBy(linkText = "View history")
	protected WebElement viewHistory;

	public WikiPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitle() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title.getText();
	}
	
	public String getBody() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body.getText();
	}
	
	public PageCreationPage edit() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		edit.click();
		return new PageCreationPage(driver);
	}
	
	public EditSourcePage editSource() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		editSource.click();
		return new EditSourcePage(driver);
	}
	
	public EditSourcePage createSource() {
		createSource.click();
		return new EditSourcePage(driver);
	}
	
	public WikiPage goToLink(String link) {
		driver.findElement(By.linkText(link)).click();
		return new WikiPage(driver);
	}
	
	public String getCategory() {
		return category.getText();
	}
	
	public PageProtectPage protect() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		more.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Protect")).click();
		return new PageProtectPage(driver);
	}
	
	public PageProtectPage changeProtectionLevel() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		more.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Change protection")).click();
		return new PageProtectPage(driver);
	}
	
	public PageCreationPage forceEdit() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.get(driver.getCurrentUrl()+"?veaction=edit");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PageCreationPage(driver);
	}
	
	public RevisionHistoryPage viewHistory() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		viewHistory.click();
		return new RevisionHistoryPage(driver);
	}
	
	public DeletePage deletePage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		more.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Delete")).click();
		return new DeletePage(driver);
	}
	
	public String getMainRedirect() {
		return driver.findElement(By.className("redirectText")).getText();
	}
	
	public String getSourceRedirect() {
		return driver.findElement(By.className("mw-redirectedfrom")).getText();
	}

}
