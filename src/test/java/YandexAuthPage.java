import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class YandexAuthPage {
    private SelenideElement loginField = $(byId("passp-field-login"));
    private SelenideElement passwordField = $(byId("passp-field-passwd"));
    private SelenideElement signInButton = $(byId("passp:sign-in"));
    private SelenideElement mailButton = $(byXpath("//button[@data-type='login']"));
    private static final String PAGE_TITLE = "Авторизация";

    //---------------------------------------------------
    //ЛОГИКА СТРАНИЦЫ
    public void enterLogin(String login) {
        loginField.should(Condition.exist).setValue(login);
    }

    public void enterPassword(String password) {
        passwordField.should(Condition.exist).setValue(password);
    }

    public void clickSignInButton() {
        signInButton.should(Condition.exist).click();
    }

    public boolean atPage() {
        return title().equals(PAGE_TITLE);
    }

    public void mailButtonClick() {
        mailButton.should(Condition.exist).click();
    }

    public String getTitle(){
        return PAGE_TITLE;
    }
}