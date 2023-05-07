import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class SettingsPage extends Page {
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]")
    private MobileElement deviceSettings;
    @AndroidFindBy(accessibility = "Перейти вверх")
    private MobileElement backButton;
    @AndroidFindBy(id = "ru.ok.android:id/name")
    private MobileElement username;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]")
    private MobileElement appearanceSettings;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.Switch")
    private MobileElement theme;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]")
    private MobileElement notificationsSection;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]")
    private MobileElement pushNotificationSection;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.Switch")
    private MobileElement doNotDisturb;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private MobileElement oneHour;

    public SettingsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void deviceSettingsClick() {
        $(deviceSettings).should(Condition.exist).click();
    }

    public void backButtonClick() {
        $(backButton).should(Condition.exist).click();
    }

    public Boolean apPage() {
        return $(username).should(Condition.exist).isDisplayed();
    }

    public Boolean isBlackThemeActive() {
        return $(theme).text().equals("ВКЛ");
    }


    public void appearanceSettingsClick() {
        $(appearanceSettings).should(Condition.exist).click();
    }

    public void themeChange() {
        $(theme).should(Condition.exist).click();
    }

    public void notificationsSectionClick() {
        $(notificationsSection).should(Condition.exist).click();
    }

    public void pushNotificationSectionClick() {
        $(pushNotificationSection).should(Condition.exist).click();
    }

    public void doNotDisturbClick() {
        $(doNotDisturb).should(Condition.exist).click();
    }

    public void oneHourClick() {
        $(oneHour).should(Condition.exist).click();
    }
}
