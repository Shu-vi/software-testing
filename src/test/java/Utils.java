import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class Utils {
    public static void swipe(int startX, int startY, int endY){
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    public static void scrollOneForward(int count) {
        AndroidDriver androidDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        for (int i = 0; i < count; i++) {
            androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()");
        }
    }

    public static void scrollOneBackward(int count) {
        AndroidDriver androidDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        for (int i = 0; i < count; i++) {
            androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()");
        }
    }

    public static void tap(int x, int y){
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        new TouchAction(driver)
                .tap(PointOption.point(x, y))
                .perform();
    }
}
