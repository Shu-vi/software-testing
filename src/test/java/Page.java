import io.appium.java_client.android.AndroidDriver;

public abstract class Page {
    protected AndroidDriver driver;

    public Page(AndroidDriver driver) {
        this.driver = driver;
    }
}
