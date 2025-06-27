import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;
import java.util.Random;

public class testmock_and_chat {
    AndroidDriver driver;

    public testmock_and_chat(AndroidDriver driver) {
        this.driver = driver;
    }

    public void run() throws InterruptedException {
        // Open Mock Exam
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Mock Exam\"]")).click();
        Thread.sleep(8000);

        // Start the test
        WebElement start = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Start\"]"));
        start.click();
        Thread.sleep(2000);


        for (int i = 0; i < 50; i++) {
            // Find all answer options
            List<WebElement> options = driver.findElements(
                    By.xpath("//android.view.ViewGroup[starts-with(@content-desc, 'A.,') or " +
                            "starts-with(@content-desc, 'B.,') or " +
                            "starts-with(@content-desc, 'C.,') or " +
                            "starts-with(@content-desc, 'D.,')]")
            );

            if (!options.isEmpty()) {
                Random rand = new Random();
                WebElement randomOption = options.get(rand.nextInt(options.size()));
                System.out.println("Selecting option: " + randomOption.getAttribute("content-desc"));
                randomOption.click();
            } else {
                System.out.println("No options found for question " + (i + 1));
            }

            Thread.sleep(1000);

            if (i < 49) {
                // Click Next for questions 1 to 49
                try {
                    WebElement next = driver.findElement(By.xpath("//android.widget.TextView[@text='Next']"));
                    next.click();
                    System.out.println("Clicked Next on question " + (i + 1));
                } catch (Exception e) {
                    System.out.println("Next button not found on question " + (i + 1));
                    break;
                }
            } else {
                // Click Submit on question 50
                try {
                    WebElement submit = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Submit\"]"));
                    submit.click();
                    System.out.println("Clicked Submit on question 50");
                } catch (Exception e) {
                    System.out.println("Submit button not found on question 50");
                }
            }

            Thread.sleep(1000);
        }



        // Show Answers
        WebElement showAnswers = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Show Answers\"]"));
        showAnswers.click();
        Thread.sleep(1000);

        // Click Back (SVG-based back icon)
        WebElement back = driver.findElement(By.xpath(
                "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView\n"));
        back.click();

        Thread.sleep(5000);

        WebElement chat = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"login\"]\n"));
        chat.click();
        WebElement chatInput = driver.findElement(By.xpath("//android.widget.EditText[@text='Start typing...']"));
        chatInput.sendKeys("Hello, tell ne some driving rules?");
        Thread.sleep(5000);
        WebElement send = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]\n"));
        send.click();
        WebElement clear = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView\n"));
        clear.click();

        WebElement clearchat = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Clear\"]\n"));
        clearchat.click();
    }
}