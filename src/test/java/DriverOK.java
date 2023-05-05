import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;


public class AndroidDriverOK implements WebDriverProvider {
    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability(MobileCapabilityType.VERSION, Properties.PLATFORM_VERSION);
        capabilities.setCapability("platformName", Properties.PLATFORM_NAME);
        capabilities.setCapability("deviceName", Properties.DEVICE_NAME);
        capabilities.setCapability(APP_PACKAGE, Properties.APP_PACKAGE);
        capabilities.setCapability(APP_ACTIVITY, Properties.APP_ACTIVITY);
        capabilities.setCapability("automationName", "UiAutomator2");

        try {
            return new AndroidDriver<>(new URL(Properties.URL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}