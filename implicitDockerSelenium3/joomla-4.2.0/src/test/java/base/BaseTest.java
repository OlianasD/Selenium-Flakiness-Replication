package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import po.BaseNavBar;
import po.ProfilePageInfo;

public class BaseTest {
	
	protected static final String rootPassword = "dodicicaratteri";
	//remember to change the URL: localhost does not work inside Selenium Standalone Chrome
	protected static final String app_url = "http://localhost:3000/";
	public static WebDriver driver;
	
	@Before
	public void goToHome() {
		setupRemoteWebdriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(app_url);
	}

	/*public void setupNativeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}");
		options.setBrowserVersion("127");
		driver = new ChromeDriver(options);
	}*/

	public void setupNativeBrowserNoSeleniumManager() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64-chrome127/chromedriver-win64/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		options.setBinary("C:\\Users\\User\\chrome\\win64-127.0.6533.119\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
	}

	public void setupRemoteWebdriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	protected ProfilePageInfo loginAsAdmin() {
		return new BaseNavBar(driver)
			.authorLogin()
			.setUsername("administrator")
			.setPassword(rootPassword)
			.login();
	}
}
