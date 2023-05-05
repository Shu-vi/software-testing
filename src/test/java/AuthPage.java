import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage extends Page {
    @AndroidFindBy(id = "ru.ok.android:id/text_login")
    private MobileElement loginField;
    @AndroidFindBy(id = "ru.ok.android:id/password_text")
    private MobileElement passwordField;
    @AndroidFindBy(id = "ru.ok.android:id/login_button")
    private MobileElement loginButton;

    public AuthPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void setLoginField(String loginField) {
        $(this.loginField).should(Condition.exist).setValue(loginField);
    }

    public void setPasswordField(String passwordField) {
        $(this.passwordField).should(Condition.exist).setValue(passwordField);
    }

    public void loginButtonClick() {
        $(this.loginButton).should(Condition.exist).click();
    }
}
