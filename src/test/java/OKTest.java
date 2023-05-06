import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OKTest {
    private static AuthPage authPage;
    private static NewsFeedPage newsFeedPage;
    private static DiscussionsPage discussionsPage;
    private static NavbarPage navbarPage;
    private static SettingsPage settingsPage;
    private static MessagesPage messagesPage;

    @BeforeAll
    public static void setUp() {
        closeWebDriver();
        Configuration.timeout = Config.TIMEOUTS;
        AppiumDriver<MobileElement> driver = DriverOK.createDriver();
        WebDriverRunner.setWebDriver(driver);
        authPage = new AuthPage(driver);
        newsFeedPage = new NewsFeedPage(driver);
        discussionsPage = new DiscussionsPage(driver);
        navbarPage = new NavbarPage(driver);
        messagesPage = new MessagesPage(driver);
        settingsPage = new SettingsPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @Order(1)
    void auth() {
        authPage.setLoginField(Properties.OK_LOGIN);
        authPage.setPasswordField(Properties.OK_PASSWORD);
        authPage.loginButtonClick();
        Assertions.assertTrue(newsFeedPage.atPage());
    }

    @Test
    @Order(2)
    public void newsFeed() {
        newsFeedPage.scrollDown();
        newsFeedPage.scrollTop();
        Assertions.assertTrue(newsFeedPage.atPage());
        newsFeedPage.discussionClick();
    }

    @Test
    @Order(3)
    public void discussion() {
        discussionsPage.scrollTop();
        Assertions.assertTrue(discussionsPage.atPage());
    }

    @Test
    @Order(4)
    public void navbar() {
        discussionsPage.leftBarClick();
        Assertions.assertTrue(navbarPage.atPage());
        navbarPage.moreClick();
        navbarPage.settingsButtonClick();
        Assertions.assertTrue(settingsPage.apPage());
    }

    @Test
    @Order(5)
    public void settings() {
        settingsPage.deviceSettingsClick();
        settingsPage.appearanceSettingsClick();
        settingsPage.themeChange();
        Assertions.assertTrue(settingsPage.isBlackThemeActive());
        settingsPage.themeChange();
        settingsPage.backButtonClick();
        settingsPage.backButtonClick();
        settingsPage.backButtonClick();
        discussionsPage.messagesClick();
    }

    @Test
    @Order(6)
    public void messages() {
        messagesPage.createChatClick();
        messagesPage.createChatConfirmClick();
        messagesPage.setChatTitle("Test chat");
        messagesPage.saveButtonClick();
        messagesPage.setTextInputField("Привет, Африка!");
        messagesPage.addAttachmentClick();
        messagesPage.allowAccessClick();
        messagesPage.photoClick();
        messagesPage.photoClick();
        messagesPage.sendPhotoClick();
    }

    @Test
    @Order(7)
    public void deleteMessage() {
        messagesPage.messageClick();
        messagesPage.deleteButtonClick();
        messagesPage.deleteConfirmClick();
        messagesPage.backButtonClick();
        messagesPage.navbarClick();
    }

    @Test
    @Order(8)
    public void doNotDisturb() {
        navbarPage.settingsButtonClick();
        settingsPage.notificationsSectionClick();
        settingsPage.pushNotificationSectionClick();
        settingsPage.doNotDisturbClick();
        settingsPage.oneHourClick();
    }
}
