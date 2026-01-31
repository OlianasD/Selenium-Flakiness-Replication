package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserProfilePage extends TopNavBar {

	@FindBy(xpath = "//*[@id=\"form-email\"]")
	WebElement formEmail;

	@FindBy(xpath = "//*[@id=\"user-section\"]/div[2]/form/div/div/button")
	WebElement saveBtn;

	public EditUserProfilePage(WebDriver driver) {
		super(driver);

	}

	public EditUserProfilePage setEmail(String mail) {
		wait.waitClickability(formEmail);
		formEmail.clear();
		formEmail.sendKeys(mail);
		return this;
	}

	public UserSummaryPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new UserSummaryPage(driver);
	}

}
