package po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ArchivedArticlesPage extends LoggedNavBar {

	public ArchivedArticlesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean containsArticle(String title) {
		try {
			driver.findElement(By.linkText(title));
		} catch(NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
