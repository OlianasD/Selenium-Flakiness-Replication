package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import po.PrestaLogin;
import utils.Wait;

public class StopOnboarding extends BaseTest {

    @Test
    public void stopOnboarding() {
        Wait wait = new Wait(driver);
        new PrestaLogin(driver)
                .loginToPresta(adminMail, adminPsw);
        wait.waitClickability(By.xpath("/html/body/div[1]/div/div/div[3]/button[2]")).click();
        wait.waitClickability(By.linkText("Skip this tutorial")).click();
        wait.waitClickability(By.linkText("Stop the OnBoarding")).click();
    }
}
