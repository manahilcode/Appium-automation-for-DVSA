import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class login {
    AndroidDriver driver;

    public login
            (AndroidDriver driver) {
        this.driver = driver;
    }

    public void run() throws InterruptedException {

        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Continue with Google']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/container'])[2]/android.widget.LinearLayout")).click();
        Thread.sleep(2000);

    }
}