package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;


public class OKTest {
//    Четный номер в группе - OK
//
//    Запуск приложения, авторизация (Можно совершить авторизацию через другой сервис)
//    Создать новый профиль или выбрать профиль (использовать Android Driver)
//
//    Переход в Ленту, Обсуждения. Проскроллить обсуждения и Ленту (использовать swipe)
//    Вызов меню: переход в настройки > внешний вид > включить/отключить темную тему
//    Выход с аккаунта

    @BeforeAll
    public static void setUp() {
        closeWebDriver();
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverWithCalculator.class.getName();
        Configuration.timeout = 120000;
        open();
    }

    @Test
    void calculator() {
        $(By.id("ru.ok.android:id/text_login")).should(exist).setValue("+79375902297");
        $(By.id("ru.ok.android:id/password_text")).should(exist).setValue("dcswuag6bw");
        $(By.id("ru.ok.android:id/login_button")).should(exist).click();
        $(By.xpath("//android.widget.ImageButton[@content-desc=\"Открыть боковое меню\"]")).should(exist);
        Utils.scrollOneForward(2);
        Utils.scrollOneBackward(1);
        $(By.xpath("//android.widget.ImageButton[@content-desc=\"Открыть боковое меню\"]")).should(exist);
        Utils.tap(321, 1726);
        Selenide.sleep(2000);
        Utils.scrollOneBackward(1);
        $(By.xpath("//android.widget.ImageButton[@content-desc=\"Открыть боковое меню\"]")).should(exist).click();
        Selenide.sleep(5000);
        Utils.tap(915, 1200);
        Selenide.sleep(5000);
        Utils.tap(200, 1200);
        $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")).should(exist).click();
        $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]")).should(exist).click();
        Selenide.sleep(5000);
        $(By.xpath("//android.view.ViewGroup[2]/android.widget.Switch")).should(exist).click();
        $(By.xpath("//android.view.ViewGroup[2]/android.widget.Switch")).should(exist).click();
        $(By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]")).should(exist).click();
        $(By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]")).should(exist).click();
        $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]")).should(exist).click();
        $(By.id("ru.ok.android:id/md_buttonDefaultPositive")).should(exist).click();
        // android.view.ViewGroup[2]/android.widget.Switch ВЫКЛ ВКЛФ
    }


}
