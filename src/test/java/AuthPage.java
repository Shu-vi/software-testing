import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private SelenideElement loginField = $(By.id("ru.ok.android:id/text_login"));
    private SelenideElement passwordField = $(By.id("ru.ok.android:id/password_text"));
    private SelenideElement loginButton = $(By.id("ru.ok.android:id/login_button"));


    public void setLoginField(String loginField) {
        this.loginField.should(exist).setValue(loginField);
    }

    public void setPasswordField(String passwordField) {
        this.passwordField.should(exist).setValue(passwordField);
    }

    public void loginButtonClick() {
        this.loginButton.should(exist).click();
    }
}
