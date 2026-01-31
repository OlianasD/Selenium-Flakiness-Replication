package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProjectPage extends ProjectSidebar {

	@FindBy(xpath = "//*[@id=\"main\"]/section/div[2]/form/fieldset[1]/div/div/div[2]/textarea")
	WebElement formDesc;

	@FindBy(xpath = "//*[@id=\"main\"]/section/div[2]/form/div/div/button")
	WebElement saveBtn;

	public EditProjectPage(WebDriver driver) {
		super(driver);

	}

	public EditProjectPage setDescription(String name) {
		wait.waitClickability(formDesc);
		formDesc.sendKeys(name);
		return this;
	}

	public EditProjectPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new EditProjectPage(driver);
	}

}
