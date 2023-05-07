import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class NewsFeedPage extends Page{
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Лента']")
    private MobileElement newsHeader;
    @AndroidFindBy(accessibility = "Обсуждения")
    private MobileElement discussionButton;
    @AndroidFindBy(accessibility = "Открыть боковое меню")
    private MobileElement navbar;
    @AndroidFindBy(accessibility = "Сообщения")
    private MobileElement messages;

    public NewsFeedPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public Boolean atPage(){
        return $(this.newsHeader).should(exist).isDisplayed();
    }

    public void scrollDown(){
        Utils.scrollOneForward(2);
    }


    public void scrollTop(){
        Utils.scrollOneBackward(1);
    }

    public void discussionClick(){
        $(discussionButton).should(exist).click();
    }

    public void navbarClick() {
        $(navbar).should(exist).click();
    }

    public void messagesClick(){
        $(messages).should(exist).click();
    }
}
