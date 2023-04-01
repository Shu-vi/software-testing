import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class YandexIdPage {
    private SelenideElement navbar = $(byXpath("//div[@class='UserID-Badge ']"));
    private SelenideElement logoutButton = $(byXpath("//div[contains(@class, 'Logout')]"));
    private SelenideElement iframeElement = $(byXpath("//iframe[@class='UserWidget-Iframe']"));
    private SelenideElement diskButton = $(".MenuItem_disk");
    private static final String PAGE_TITLE = "Яндекс ID";

    //---------------------------------------------------
    //ЛОГИКА СТРАНИЦЫ
    public boolean atPage() {
        return title().equals(PAGE_TITLE);
    }

    public String getTitle() {
        return PAGE_TITLE;
    }

    public void navbarClick() {
        navbar.should(Condition.exist).click();
    }

    public void logoutButtonClick() {
        switchTo().frame(iframeElement);
        logoutButton.should(Condition.exist).click();
        switchTo().defaultContent();
    }

    public void diskButtonClick() {
        switchTo().frame(iframeElement);
        diskButton.should(Condition.exist).click();
        switchTo().defaultContent();
    }
}