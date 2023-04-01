import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class YandexDiskPage {
    private static final String PAGE_TITLE = "Яндекс.Диск";
    private SelenideElement uploadButton = $(".upload-button__attach");
    private SelenideElement uploadedFile = $(By.xpath("//span[contains(text(), 'Отчёт')]"));
    private SelenideElement downloadButton = $(By.xpath("//button[contains(@class, 'ufo-resources-action-bar__primary-button_action_download')][1]"));
    private SelenideElement navbar = $(".PSHeader-User");
    private SelenideElement exitButton = $(".legouser__menu-item_action_exit");
    private SelenideElement headerCloseButton = $(".resources-action-bar__close");

    //----------------------------------------------
    //ГЕТТЕРЫ
    public SelenideElement getUploadedFile() {
        return uploadedFile;
    }

    public SelenideElement getUploadButton() {
        return uploadButton;
    }

    //------------------------------------------------
    //ЛОГИКА СТРАНИЦЫ
    public void uploadFile(File file) {
        uploadButton.should(Condition.exist).uploadFile(file);
    }

    public Boolean atPage() {
        return title().equals(PAGE_TITLE);
    }

    public void uploadedFileClick() {
        uploadedFile.should(Condition.exist).click();
    }

    public void downloadButtonClick() throws FileNotFoundException {
        downloadButton.should(Condition.exist).click();
    }

    public void navbarClick() {
        navbar.should(Condition.exist).click();
    }

    public void exitButtonClick() {
        exitButton.should(Condition.exist).click();
    }

    public void headerCloseButtonClick(){
        headerCloseButton.should(Condition.exist).click();
    }
}
