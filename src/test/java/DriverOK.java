import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class DriverOK {
    public static AppiumDriver<MobileElement> createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (Config.PLATFORM) {
            case IOS : {
                return setIOSCapabilities(capabilities);
            }
            case ANDROID: {
                return setAndroidCapabilities(capabilities);
            }
            default:
                throw new RuntimeException("Incorrect platform");
        }
    }

    private static IOSDriver<MobileElement> setIOSCapabilities(DesiredCapabilities capabilities) {
        IOSDriver<MobileElement> driver = null;
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\ios.json";
        JSONObject appiumJson = JSONService.readJsonFromFile(path);
        JSONObject caps = JSONService.getCapabilities(appiumJson);
        caps.keySet().forEach(keyStr -> capabilities.setCapability(keyStr, caps.get(keyStr)));
        try {
            driver = new IOSDriver<>(new URL(JSONService.getUrl(appiumJson)), capabilities);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }

    private static AndroidDriver<MobileElement> setAndroidCapabilities(DesiredCapabilities capabilities) {
        AndroidDriver<MobileElement> driver = null;
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\pixel2.json";
        JSONObject appiumJson = JSONService.readJsonFromFile(path);
        JSONObject caps = JSONService.getCapabilities(appiumJson);
        caps.keySet().forEach(keyStr -> capabilities.setCapability(keyStr, caps.get(keyStr)));
        try {
            driver = new AndroidDriver<>(new URL(JSONService.getUrl(appiumJson)), capabilities);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }
}