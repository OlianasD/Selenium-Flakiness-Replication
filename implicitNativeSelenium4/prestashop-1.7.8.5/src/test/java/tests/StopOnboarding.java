package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import po.PrestaLogin;

public class StopOnboarding extends BaseTest {

    @Test
    public void stopOnboarding() {
        new PrestaLogin(driver)
                .loginToPresta(adminMail, adminPsw);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[2]")).click();
        driver.findElement(By.linkText("Skip this tutorial")).click();
        driver.findElement(By.linkText("Stop the OnBoarding")).click();
    }
}
