import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class Page {
    protected AppiumDriver<MobileElement> driver;

    public Page(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}
