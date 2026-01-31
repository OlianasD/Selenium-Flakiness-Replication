package mediawiki;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.RemoteWebDriver;
import po.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
	
	public static WebDriver driver;
	//remember to change the URL: localhost does not work inside Selenium Standalone Chrome
	public static final String app_url = "http://localhost:8080";
	
	@Before
	public void setUp() {
		setupRemoteWebDriver();
		driver.manage().window().maximize();
		driver.get(app_url);
	}

	public void setupNativeBrowserNoSeleniumManager() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64-chrome127/chromedriver-win64/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		options.setBinary("C:\\Users\\User\\chrome\\win64-127.0.6533.119\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
	}

	protected void setupNativeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		options.setBrowserVersion("127");
		driver = new ChromeDriver(options);
	}

	protected void setupRemoteWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected MainPage loginAsAdmin() {
		return new MainPage(driver)
				.login()
				.setUsername("admin")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.login();
	}
	
	protected MainPage loginAsUser() {
		return new MainPage(driver)
				.login()
				.setUsername("User001")
				.setPassword("e2eW3Bt3s71nGB3nchM4rK")
				.login();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
