## Задание
Оптимизация кода для тестов. Подготовка для запуск на iOS:
1) Оптимизируйте Page Object. Desired Capabilities должны храниться отдельно от пейджей и тестов - в json файле. Каждый элемент нужно ожидать методами Selenide:
2) Тестируемое .apk должно лежать в папке resources, в случае с Browserstack .apk файл хранится ресуре фермы.
    Подразумевается, что запустить можно на эмуляторе или ферме.
    Проверяйте очистку куки и кэша на устройстве перед запуском тестов методами adb.
3) Переписать Capabilities и SetUp() :   См BaseTest.javaprivate private setAndroidCapabilities() добавить поддержку iOS private setIOSCapabilities()

   Для инициализации элементов использовать AppiumFieldDecorator из io.appium.java_client.pagefactory.AppiumFieldDecorator;

   Пример объявления локатора:

protected AppiumDriver driver;

public BaseScreen(AppiumDriver driver) {

this.driver = driver;

PageFactory.initElements(new AppiumFieldDecorator(driver), this);

}

@iOSXCUIFindBy(accessibility = "send")

@AndroidFindBy(xpath = "//*[@text='send']")

private SelenideElement sendBtn

public static boolean isIOS() {

return PLATFORM_IOS.equals(platform)

}

public static boolean isAndroid() {

return PLATFORM_ANDROID.equals(platform)

}

public void sendMessage () {

if (isAndroid()) {...}

if(isIOS()) {...}

BrowserStack и фермы эмуляторов

Запускайте тесты используя фермы эмуляторов. Например, Browserstack и так далее.

Подробнее https://medium.com/effective-developers/запуск-автотестов-на-реальных-устройствах-с-помощью-amazon-device-farm-и-browserstack-6b77c259e0ac

Вам нужно будет дописать соответствующие зависимости в файл управления сборки тестов. Убедитесь, что используются самые последние версии плагинов для appium.

Дополните автотесты:

- VK https://play.google.com/store/apps/details?id=com.vkontakte.android&hl=ru&gl=US
- Создать чат с 1 участником.
- Отправка сообщения с прикрепленным файлом img (в созданный чат)
- Удаление сообщения (для всех участников чата)
- Вызов меню: переход в настройки > Не беспокоить > 1 час > готово

OK https://play.google.com/store/apps/details?id=ru.ok.android&hl=ru&gl=US

- Создать чат с 1 участником.
- Отправка сообщения с прикрепленным файлом img (в созданный чат)
- Удаление сообщения (для всех участников чата)
- Вызов меню: переход в настройки > Оповещения и уведомления > Настройка push уведомлений > Не беспокоить

Материалы:
- https://appium.io
- https://appium.io/docs/en/about-appium/api/
- https://habr.com/ru/post/488482/