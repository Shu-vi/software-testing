import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class DiscussionsPage {
    private SelenideElement leftBar = $(By.xpath("//android.widget.ImageButton[@content-desc=\"Открыть боковое меню\"]"));
    private SelenideElement discussionHeader = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"));

    public void scrollTop() {
        Utils.scrollOneBackward(1);
    }

    public void leftBarClick() {
        leftBar.should(Condition.exist).click();
    }

    public boolean atPage() {
        return discussionHeader.should(exist).isDisplayed();
    }

}
