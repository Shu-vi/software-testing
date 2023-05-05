import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class DiscussionsPage extends Page {
    @AndroidFindBy(accessibility = "Открыть боковое меню")
    private MobileElement leftBar;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Обсуждения']")
    private MobileElement discussionHeader;

    public DiscussionsPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void scrollTop() {
        Utils.scrollOneBackward(1);
    }

    public void leftBarClick() {
        $(leftBar).should(exist).click();
    }

    public boolean atPage() {
        return $(discussionHeader).should(exist).isDisplayed();
    }

}
