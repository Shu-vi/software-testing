import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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
    @AndroidFindBy(accessibility = "Сообщения")
    private MobileElement messages;
    public DiscussionsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void scrollTop() {
        Utils.scrollOneBackward(1);
    }

    public void leftBarClick() {
        $(leftBar).should(exist).click();
    }

    public void messagesClick(){
        $(messages).should(exist).click();
    }

    public boolean atPage() {
        return $(discussionHeader).should(exist).isDisplayed();
    }

}
