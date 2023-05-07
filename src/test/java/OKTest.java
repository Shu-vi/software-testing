import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.*;


public class OKTest {
    private AuthPage authPage;
    private NewsFeedPage newsFeedPage;
    private DiscussionsPage discussionsPage;
    private NavbarPage navbarPage;
    private SettingsPage settingsPage;
    private MessagesPage messagesPage;


    @BeforeEach
    public void setUpTest() {
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

    @AfterEach
    public void tearDownTest() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    void auth() {
        authPage.auth(Properties.OK_LOGIN, Properties.OK_PASSWORD);
        Assertions.assertTrue(newsFeedPage.atPage());
    }

    @Test
    public void newsFeedScroll() {
        authPage.auth(Properties.OK_LOGIN, Properties.OK_PASSWORD);
        newsFeedPage.scrollDown();
        newsFeedPage.scrollTop();
        Assertions.assertTrue(newsFeedPage.atPage());
    }

    @Test
    public void discussionScroll() {
        authPage.auth(Properties.OK_LOGIN, Properties.OK_PASSWORD);
        newsFeedPage.discussionClick();
        discussionsPage.scrollTop();
        Assertions.assertTrue(discussionsPage.atPage());
    }

    @Test
    public void changeTheme() {
        authPage.auth(Properties.OK_LOGIN, Properties.OK_PASSWORD);
        newsFeedPage.navbarClick();
        Assertions.assertTrue(navbarPage.atPage());
        navbarPage.moreClick();
        navbarPage.settingsButtonClick();
        Assertions.assertTrue(settingsPage.apPage());
        settingsPage.deviceSettingsClick();
        settingsPage.appearanceSettingsClick();
        settingsPage.themeChange();
        Assertions.assertTrue(settingsPage.isBlackThemeActive());
        settingsPage.themeChange();
        Assertions.assertFalse(settingsPage.isBlackThemeActive());
    }

    @Test
    public void logout() {
        authPage.auth(Properties.OK_LOGIN, Properties.OK_PASSWORD);
        newsFeedPage.navbarClick();
        Assertions.assertTrue(navbarPage.atPage());
        navbarPage.moreClick();
        navbarPage.exitButtonClick();
        navbarPage.exitButtonConfirmClick();
    }

    @Test
    public void createChatAndSendMessageAndDeleteMessage() {
        authPage.auth(Properties.OK_LOGIN, Properties.OK_PASSWORD);
        newsFeedPage.messagesClick();
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
        messagesPage.messageClick();
        messagesPage.deleteButtonClick();
        messagesPage.deleteConfirmClick();
    }

    @Test
    public void setStatusDoNotDisturb() {
        authPage.auth(Properties.OK_LOGIN, Properties.OK_PASSWORD);
        newsFeedPage.navbarClick();
        Assertions.assertTrue(navbarPage.atPage());
        navbarPage.moreClick();
        navbarPage.settingsButtonClick();
        Assertions.assertTrue(settingsPage.apPage());
        settingsPage.notificationsSectionClick();
        settingsPage.pushNotificationSectionClick();
        settingsPage.doNotDisturbClick();
        settingsPage.oneHourClick();
    }
}
