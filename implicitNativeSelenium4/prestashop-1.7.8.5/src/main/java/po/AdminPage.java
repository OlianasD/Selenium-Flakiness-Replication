package po;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AdminPage extends AdminSidebar {
	
    @FindBy(className = "page-title")
	public WebElement adminPageDashboard;
    
    public AdminPage(WebDriver driver){
        super(driver);
    }   
    
    public String getAdminPageDashboardTitle(){
         return  adminPageDashboard.getText();
      }

}
