import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class YandexAuthTest {
    private static YandexAuthPage yandexAuthPage;
    private static YandexIdPage yandexIdPage;
    private static YandexDiskPage yandexDiskPage;
    private static File file;

    @BeforeAll
    public static void setUp() {
        yandexAuthPage = new YandexAuthPage();
        yandexIdPage = new YandexIdPage();
        yandexDiskPage = new YandexDiskPage();
        Configuration.timeout = 120000;
        open("https://passport.yandex.ru/");
        file = new File(Properties.PATH_TO_PDF_FILE);
    }

    @Test
    @Order(1)
    public void authPositive() {
        yandexAuthPage.mailButtonClick();
        Assertions.assertTrue(yandexAuthPage.atPage());
        yandexAuthPage.enterLogin(Properties.YANDEX_LOGIN);
        yandexAuthPage.clickSignInButton();
        yandexAuthPage.enterPassword(Properties.YANDEX_PASSWORD);
        yandexAuthPage.clickSignInButton();
        Selenide.Wait().until(ExpectedConditions.titleIs(yandexIdPage.getTitle()));
        Assertions.assertTrue(yandexIdPage.atPage());
    }


    @Test
    @Order(2)
    public void uploadToDiskPositive(){
        yandexIdPage.navbarClick();
        yandexIdPage.diskButtonClick();

        if (!yandexDiskPage.getUploadedFile().isDisplayed()) {
            yandexDiskPage.uploadFile(file);
            Assertions.assertTrue(yandexDiskPage.getUploadedFile().isDisplayed());
        }
        yandexDiskPage.uploadedFileClick();
        try {
            yandexDiskPage.downloadButtonClick();
            Selenide.sleep(10000);
        } catch (FileNotFoundException e) {
            System.out.println("Исключение");
        }
        File file = new File("build/downloads");
        file = new File(file.listFiles()[0].getAbsolutePath() + "/" + "Отчёт по технологической практике 3 семестр .pdf");
        PDF pdf = null;
        try {
            pdf = new PDF(file);
        } catch (IOException e) {
            System.out.println("Исключение 2");
        }
        yandexDiskPage.headerCloseButtonClick();
        Assertions.assertTrue(pdf.text.contains("В рамках данной практики была"));
    }

    @Test
    @Order(3)
    public void logoutPositive() {
        yandexDiskPage.navbarClick();
        yandexDiskPage.exitButtonClick();
        Assertions.assertTrue(yandexAuthPage.atPage());
    }
}
