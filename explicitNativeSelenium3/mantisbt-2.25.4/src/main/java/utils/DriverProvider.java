package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverProvider {

    private static DriverProvider ourInstance = new DriverProvider();

    private DriverProvider(){
    	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    	//WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.silentOutput", "true");
        Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
    }

    public WebDriver getDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("/opt/google/chrome-beta/google-chrome-beta");
        //if(Boolean.valueOf(Properties.getInstance().getProperty("headless_browser"))){
            chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-gpu", "--window-size=1920x1080");
        //}
        return new ChromeDriver(chromeOptions);
    }

    public static DriverProvider getInstance(){
        return ourInstance;
    }
}
