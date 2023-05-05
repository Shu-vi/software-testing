import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
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
    @AndroidFindBy(xpath = "//android.view.ViewGroup[7]")
    private MobileElement exitButton;
    @AndroidFindBy(id = "ru.ok.android:id/md_buttonDefaultPositive")
    private MobileElement confirmExitButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]")
    private MobileElement appearanceSettings;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.Switch")
    private MobileElement theme;

    public SettingsPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void deviceSettingsClick() {
        $(deviceSettings).should(Condition.exist).click();
    }

    public void backButtonClick() {
        $(backButton).should(Condition.exist).click();
    }

    public void exitButtonClick() {
        $(exitButton).should(Condition.exist).click();
    }

    public void exitButtonConfirmClick() {
        $(confirmExitButton).should(Condition.exist).click();
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

}
