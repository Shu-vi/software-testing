import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexAuthTest {

    private static WebDriver driver;
    private static YandexAuthPage yandexAuthPage;
    private static WebDriverWait wait;
    private static YandexIdPage yandexIdPage;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", Properties.PATH_TO_CHROME_DRIVER);
        driver = new ChromeDriver(options);
        yandexAuthPage = new YandexAuthPage(driver);
        yandexIdPage = new YandexIdPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://passport.yandex.ru/");
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void authPositive() {
        Assertions.assertTrue(yandexAuthPage.atPage());
        wait.until(ExpectedConditions.visibilityOf(yandexAuthPage.getMailButton()));
        yandexAuthPage.mailButtonClick();
        wait.until(ExpectedConditions.visibilityOf(yandexAuthPage.getLoginField()));
        yandexAuthPage.enterLogin(Properties.YANDEX_LOGIN);
        yandexAuthPage.clickSignInButton();
        wait.until(ExpectedConditions.visibilityOf(yandexAuthPage.getPasswordField()));
        yandexAuthPage.enterPassword(Properties.YANDEX_PASSWORD);
        yandexAuthPage.clickSignInButton();
        wait.until(ExpectedConditions.visibilityOf(yandexIdPage.getNavbar()));
        Assertions.assertTrue(yandexIdPage.atPage());
    }

    @Test
    public void logoutPositive() {
        yandexIdPage.navbarClick();
        yandexIdPage.logoutButtonClick();
        Assertions.assertTrue(yandexAuthPage.atPage());
    }
}
