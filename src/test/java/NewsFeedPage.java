import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class NewsFeedPage {
    private SelenideElement newsHeader = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));
    private SelenideElement discussionButton = $(By.xpath("//android.view.ViewGroup[@content-desc=\"Обсуждения\"]/android.widget.ImageView"));


    public Boolean atPage(){
        return newsHeader.should(exist).isDisplayed();
    }

    public void scrollDown(){
        Utils.scrollOneForward(2);
    }

    public void scrollTop(){
        Utils.scrollOneBackward(1);
    }

    public void discussionClick(){
        discussionButton.click();
    }
}
