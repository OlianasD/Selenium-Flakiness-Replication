package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentPage extends AdminSidebar {
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[1]/td[1]/div[1]/a")
	protected WebElement firstContentTitle;
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[1]/td[3]/a[2]")
	protected WebElement firstContentEdit;
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[1]/td[2]/a")
	protected WebElement firstElementUrl;
	
	@FindBy(id = "draft-tab")
	protected WebElement draftTab;
	
	@FindBy(id = "sticky-tab")
	protected WebElement stickyTab;
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[3]/td[3]/a[2]")
	protected WebElement thirdContentEdit;
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[3]/td[3]/a[3]")
	protected WebElement deleteThirdContent;

	public ContentPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFirstContentTitle() {
		return firstContentTitle.getText();
	}
	
	public NewContentPage editFirstContent() {
		firstContentEdit.click();
		return new NewContentPage(driver);
	}
	
	public NewContentPage editThirdContent() {
		thirdContentEdit.click();
		return new NewContentPage(driver);
	}
	
	public DraftPage drafts() {
		draftTab.click();
		return new DraftPage(driver);
	}
	
	public StickyPage sticky() {
		stickyTab.click();
		return new StickyPage(driver);
	}
	
	
	public String getFirstElementUrl() {
		return firstElementUrl.getText();
	}
	
	public ContentPage deleteThirdElement() {
		deleteThirdContent.click();
		return this;
	}
	
	public ContentPage confrmDelete() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"jsdeletePageModal\"]/div/div/div[2]/button[2]")).click();
		return this;
	}
	
	public boolean containsElement(String elem) {
		return driver.findElement(By.id("pages")).getText().contains(elem);
	}

}
