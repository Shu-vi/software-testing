import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavbarPage {

    private SelenideElement username = $(By.id("ru.ok.android:id/nav_menu_item_profile_name"));
    private SelenideElement more = $(By.xpath("//android.view.ViewGroup[@content-desc=\"Ещё\"]"));
    private SelenideElement settingsButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[10]"));

    public void settingsButtonClick() {
        settingsButton.should(Condition.exist).click();
    }

    public void moreClick() {
        more.should(Condition.exist).click();
    }

    public Boolean atPage() {
        return username.should(Condition.exist).isDisplayed();
    }
}
