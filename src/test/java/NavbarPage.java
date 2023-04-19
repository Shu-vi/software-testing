import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavbarPage {

    private SelenideElement username = $(By.id("ru.ok.android:id/nav_menu_item_profile_name"));
    private SelenideElement more = $(By.xpath("//android.view.ViewGroup[@content-desc=\"Ещё\"]"));
    public void moreClick(){
        more.should(Condition.exist).click();
    }

    public Boolean atPage() {
        return username.should(Condition.exist).isDisplayed();
    }
}
