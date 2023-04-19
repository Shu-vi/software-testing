import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OKTest {
    private static AuthPage authPage;
    private static NewsFeedPage newsFeedPage;
    private static DiscussionsPage discussionsPage;
    private static NavbarPage navbarPage;
    private static ListMenuPage listMenuPage;
    private static SettingsPage settingsPage;
    private static SettingsPage.Appearance appearance;
    @BeforeAll
    public static void setUp() {
        closeWebDriver();
        authPage = new AuthPage();
        newsFeedPage = new NewsFeedPage();
        discussionsPage = new DiscussionsPage();
        navbarPage = new NavbarPage();
        listMenuPage = new ListMenuPage();
        settingsPage = new SettingsPage();
        appearance = settingsPage.new Appearance();
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverOK.class.getName();
        Configuration.timeout = 120000;
        open();
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
    public void newsFeed(){
        newsFeedPage.scrollDown();
        newsFeedPage.scrollTop();
        Assertions.assertTrue(newsFeedPage.atPage());
        newsFeedPage.discussionClick();
    }

    @Test
    @Order(3)
    public void discussion(){
        discussionsPage.scrollTop();
        Assertions.assertTrue(discussionsPage.atPage());
    }

    @Test
    @Order(4)
    public void navbar(){
        discussionsPage.leftBarClick();
        Assertions.assertTrue(navbarPage.atPage());
        navbarPage.moreClick();
        listMenuPage.settingsButtonClick();
        Assertions.assertTrue(settingsPage.apPage());
    }

    @Test
    @Order(5)
    public void settings(){
        settingsPage.deviceSettingsClick();
        appearance.appearanceSettingsClick();
        appearance.themeChange();
        appearance.themeChange();
        settingsPage.backButtonClick();
        settingsPage.backButtonClick();
        settingsPage.exitButtonClick();
        settingsPage.exitButtonConfirmClick();
    }


}
