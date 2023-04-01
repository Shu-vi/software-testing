<h1>Задание</h1>
<ul>
    <li>Рефакторинг имеющихся тестов на стек Selenide. Использовать паттерн для тестов Page Object</li>
    Четный номер студента в группе - kpfu.ru
    Нечетный номер студента в группе - <strong><i>passport.yandex.ru</i></strong>
    <li>Добавить сценарий выгрузки pdf файла методами selenide
    Для kpfu.ru - переход в образцы заявлений, выгрузка pdf образца заявления
    Для yandex.ru - переход в disk.yandex.ru и сперва написать автотест на загрузку pdf методами selenide на Диск, затем скачать этот pdf файл из своего диска с помощью Selenide</li>
    <br/>
    После выгрузки файла открыть файл и проверить, что в нем есть заголовок документа, например
    PDF pdf = new PDF(statementPdf);   
    assertThat(pdf, PDF.containsText("Образец заявления"));
    <li>Использовать методы проверки состояния элементов: should(exist) shouldBe(visible), ShouldHave(exactText(“Some text”)).
По умолчанию здесь ожидается элемент 4 секунды, если вам нужно</li>
    <li>(!) Не использовать явные ожидания</li>
    <li>Подключить AllureSelenide для создания скриншотов упавших тестов</li>
    <li>Материал: 
Описание Selenide: https://comaqa.gitbook.io/selenium-webdriver-lectures/selenium-webdriver.-rasshirenie-instrumenta/selenide
Selenide примеры кода: https://github.com/selenide-examples
https://comaqa.gitbook.io/selenium-webdriver-lectures/selenium-webdriver.-rasshirenie-instrumenta/selenide
Selenide vs Selenium: https://habr.com/ru/company/otus/blog/651967/</li>
</ul>