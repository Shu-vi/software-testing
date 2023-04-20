import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {
    private SelenideElement deviceSettings = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));
    private SelenideElement backButton = $(By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]"));
    private SelenideElement username = $(By.id("ru.ok.android:id/name"));
    private SelenideElement exitButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]"));
    private SelenideElement confirmExitButton = $(By.id("ru.ok.android:id/md_buttonDefaultPositive"));
    private SelenideElement appearanceSettings = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));
    private SelenideElement theme = $(By.xpath("//android.view.ViewGroup[2]/android.widget.Switch"));

    public void deviceSettingsClick() {
        deviceSettings.should(Condition.exist).click();
    }

    public void backButtonClick() {
        backButton.should(Condition.exist).click();
    }

    public void exitButtonClick() {
        exitButton.should(Condition.exist).click();
    }

    public void exitButtonConfirmClick() {
        confirmExitButton.should(Condition.exist).click();
    }

    public Boolean apPage() {
        return username.should(Condition.exist).isDisplayed();
    }

    public Boolean isBlackThemeActive() {
        return theme.text().equals("ВКЛ");
    }


    public void appearanceSettingsClick() {
        appearanceSettings.should(Condition.exist).click();
    }

    public void themeChange() {
        theme.should(Condition.exist).click();
    }

}
