import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class NavbarPage extends Page {
    @AndroidFindBy(id = "ru.ok.android:id/nav_menu_item_profile_name")
    private MobileElement username;
    @AndroidFindBy(accessibility = "Ещё")
    private MobileElement more;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[10]")
    private MobileElement settingsButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Выйти']")
    private MobileElement exitButton;
    @AndroidFindBy(id = "ru.ok.android:id/md_buttonDefaultPositive")
    private MobileElement confirmExitButton;

    public NavbarPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void settingsButtonClick() {
        $(settingsButton).should(exist).click();
    }

    public void moreClick() {
        $(more).should(exist).click();
    }

    public Boolean atPage() {
        return $(username).should(exist).isDisplayed();
    }

    public void exitButtonClick() {
        $(exitButton).should(Condition.exist).click();
    }

    public void exitButtonConfirmClick() {
        $(confirmExitButton).should(Condition.exist).click();
    }
}
