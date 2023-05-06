import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class MessagesPage extends Page {
    @AndroidFindBy(id = "ru.ok.android:id/fab")
    private MobileElement createChat;
    @AndroidFindBy(id = "ru.ok.android:id/contacts_multi_picker_fragment__b_action_button")
    private MobileElement createChatConfirm;
    @AndroidFindBy(id = "ru.ok.android:id/text")
    private MobileElement chatTitle;
    @AndroidFindBy(id = "ru.ok.android:id/md_buttonDefaultPositive")
    private MobileElement saveButton;
    @AndroidFindBy(accessibility = "Добавить вложение")
    private MobileElement addAttachment;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement allowAccess;
    @AndroidFindBy(id = "ru.ok.android:id/iv_image")
    private MobileElement photo;
    @AndroidFindBy(id = "ru.ok.android:id/bottom_panel_action_btn")
    private MobileElement sendPhoto;
    @AndroidFindBy(id = "ru.ok.android:id/view_message__tv_text")
    private MobileElement message;
    @AndroidFindBy(id = "ru.ok.android:id/new_message_text")
    private MobileElement inputField;
    @AndroidFindBy(id = "ru.ok.android:id/message_context_menu_delete")
    private MobileElement deleteButton;
    @AndroidFindBy(id = "ru.ok.android:id/md_buttonDefaultPositive")
    private MobileElement deleteConfirm;
    @AndroidFindBy(accessibility = "Перейти вверх")
    private MobileElement backButton;
    @AndroidFindBy(accessibility = "Открыть боковое меню")
    private MobileElement navbar;

    public MessagesPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void createChatClick() {
        $(createChat).should(Condition.exist).click();
    }

    public void createChatConfirmClick() {
        $(createChatConfirm).should(Condition.exist).click();
    }

    public void setChatTitle(String chatTitle) {
        $(this.chatTitle).should(Condition.exist).setValue(chatTitle);
    }

    public void saveButtonClick() {
        $(saveButton).should(Condition.exist).click();
    }

    public void addAttachmentClick() {
        $(addAttachment).should(Condition.exist).click();
    }

    public void allowAccessClick() {
        $(allowAccess).should(Condition.exist).click();
    }

    public void photoClick() {
        $(photo).should(Condition.exist).click();
    }

    public void sendPhotoClick() {
        $(sendPhoto).should(Condition.exist).click();
    }

    public void messageClick() {
        $(message).should(Condition.exist).click();
    }

    public void setTextInputField(String message) {
        $(inputField).should(Condition.exist).setValue(message);
    }

    public void deleteButtonClick() {
        $(deleteButton).should(Condition.exist).click();
    }

    public void deleteConfirmClick() {
        $(deleteConfirm).should(Condition.exist).click();
    }

    public void backButtonClick() {
        $(backButton).should(Condition.exist).click();
    }

    public void navbarClick() {
        $(navbar).should(Condition.exist).click();
    }
}