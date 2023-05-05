import io.appium.java_client.android.AndroidDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class DriverOK {
    public static AndroidDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (Config.PLATFORM) {
//            case IOS -> {
//                return setIOSCapabilities(capabilities);
//            }
            case ANDROID: {
                return setAndroidCapabilities(capabilities);
            }
            default:
                throw new RuntimeException("Incorrect platform");
        }
    }

//    private MyAndroidDriver setIOSCapabilities(DesiredCapabilities capabilities) {
//        IOSDriver<MobileElement> driver = null;
//        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\ios.json";
//        JSONObject appiumJson = JSONService.readJsonFromFile(path);
//        JSONObject caps = JSONService.getCapabilities(appiumJson);
//        caps.keySet().forEach(keyStr -> capabilities.setCapability(keyStr, caps.get(keyStr)));
//        try {
//            driver = new IOSDriver<>(new URL(JSONService.getUrl(appiumJson)), capabilities);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return driver;
//    }

    private static AndroidDriver setAndroidCapabilities(DesiredCapabilities capabilities) {
        AndroidDriver driver = null;
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\pixel2.json";
        JSONObject appiumJson = JSONService.readJsonFromFile(path);
        JSONObject caps = JSONService.getCapabilities(appiumJson);
        caps.keySet().forEach(keyStr -> capabilities.setCapability(keyStr, caps.get(keyStr)));
        try {
            driver = new AndroidDriver(new URL(JSONService.getUrl(appiumJson)), capabilities);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return driver;
    }
}