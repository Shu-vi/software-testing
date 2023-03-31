import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.open;

public class YandexAuthTest {
    private static YandexAuthPage yandexAuthPage;
    private static YandexIdPage yandexIdPage;

    @BeforeAll
    public static void setUp() {
        yandexAuthPage = new YandexAuthPage();
        yandexIdPage = new YandexIdPage();
        open("https://passport.yandex.ru/");
    }

    @Test
    public void authPositive() {
        yandexAuthPage.mailButtonClick();
        Assertions.assertTrue(yandexAuthPage.atPage());
        yandexAuthPage.enterLogin(Properties.YANDEX_LOGIN);
        yandexAuthPage.clickSignInButton();
        yandexAuthPage.enterPassword(Properties.YANDEX_PASSWORD);
        yandexAuthPage.clickSignInButton();
        Selenide.Wait().until(ExpectedConditions.titleIs(yandexIdPage.getTitle()));
        Assertions.assertTrue(yandexIdPage.atPage());
    }

    @Test
    public void logoutPositive() {
        yandexIdPage.navbarClick();
        yandexIdPage.logoutButtonClick();
        Selenide.Wait().until(ExpectedConditions.titleIs(yandexAuthPage.getTitle()));
        Assertions.assertTrue(yandexAuthPage.atPage());
    }
}
