import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class Quiz {
    AndroidDriver driver;

    public Quiz(AndroidDriver driver) {
        this.driver = driver;
    }

    public void run() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Quiz\"]")).click();
        Thread.sleep(2000);

        WebElement type = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Alertness\"]"));
        type.click();
        Thread.sleep(2000);

        // XPaths of answers for each question (1–26)
        String[] xpaths = {
                "//android.view.ViewGroup[@content-desc=\"A., Give an arm signal as well as using your indicators\"]",
                "//android.view.ViewGroup[@content-desc=\"B., Slow down\"]",
                "//android.view.ViewGroup[@content-desc=\"C., On a dual carriageway\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Overtaking traffic should move back to the left\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Leave it until you have stopped in a safe place\"]",
                "//android.view.ViewGroup[@content-desc=\"A., To help you choose the correct lane\"]",
                "//android.view.ViewGroup[@content-desc=\"D., Brake hard\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Select a higher gear\"]",
                "//android.view.ViewGroup[@content-desc=\"A., You'll be able to corner more quickly\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Because you'll need to brake sharply and stop\"]",
                "//android.view.ViewGroup[@content-desc=\"A., Stop and then move forward slowly and carefully for a clear view\"]",
                "//android.view.ViewGroup[@content-desc=\"B., Your sun visor might get tangled\"]",
                "//android.view.ViewGroup[@content-desc=\"A., Play some loud music\"]",
                "//android.view.ViewGroup[@content-desc=\"D., Because the street lights are lit\"]",
                "//android.view.ViewGroup[@content-desc=\"A., Using a mobile phone\"]",
                "//android.view.ViewGroup[@content-desc=\"B., When you've parked safely\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Select reverse gear\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Look around after moving off\"]",
                "//android.view.ViewGroup[@content-desc=\"D., Change down one gear before you pass\"]",
                "//android.view.ViewGroup[@content-desc=\"D., When you're approaching bends and junctions\"]",
                "//android.view.ViewGroup[@content-desc=\"D., Ask someone to guide you\"]",
                "//android.view.ViewGroup[@content-desc=\"A., An area covered by your right-hand mirror\"]",
                "//android.view.ViewGroup[@content-desc=\"C., It will reduce your view\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Check that the central reservation is wide enough for your vehicle\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Motorcyclists\"]",
                "//android.view.ViewGroup[@content-desc=\"C., Only set the destination when you're lost\"]"
        };

        for (int i = 0; i < xpaths.length; i++) {
            try {
                // Select answer
                WebElement option = driver.findElement(By.xpath(xpaths[i]));
                option.click();
                System.out.println("Selected answer for Q" + (i + 1));
                Thread.sleep(1000);

                if (i < xpaths.length - 1) {
                    // Click Next for questions 1–25
                    WebElement next = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]"));
                    next.click();
                    System.out.println("Clicked Next on Q" + (i + 1));
                } else {
                    // Click Submit on Q26
                    WebElement submit = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Submit\"]"));
                    submit.click();
                    System.out.println("Clicked Submit on Q26");
                }

                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error on question " + (i + 1) + ": " + e.getMessage());
                break;
            }
        }
        // Show answers
        WebElement showanswers = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Show Answers\"]"));
        showanswers.click();
        Thread.sleep(1000);
        WebElement back = driver.findElement(By.xpath(
                "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]" +
                        "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                        "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView"));
        back.click();


    }
}
