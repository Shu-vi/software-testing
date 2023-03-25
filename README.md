<h1>Задание</h1>
<h4>Автоматизировать процес авторизации в личном кабинете.</h4>
<p><strong>Стек:</strong></p>
<ul>
    <li>Selenium (WebDriver)</li>
    <li>Java</li>
    <li>Браузер: Chrome</li>
</ul>
<p><strong>Четное число в списке группы:</strong> автоматизация входа в личный кабинет - <a href="https://kpfu.ru">kpfu.ru</a></p>
<p><strong>Нечётное число<u><i>(Мой вариант)</i></u> в списке группы:</strong> автоматизация входа в личный кабинет - <a href="https://passport.yandex.ru">passport.yandex.ru</a></p>
<p>Для поиска и идентификации элементов объявить объект драйвера, затем использовать статические методы (лоаторы) класса By (Xpath, classname, id)</p>
<p>Сценарии:</p>
<ol>
    <li>Запуск/инициализация Selenium WebDriver. Запуск браузера Chrome (ChromeDriver)</li>
    <li>DOM. Поиск элементов на странице выполнить при помощи локаторов (CSS, Xpath,classname,id)</li>
    <li>Автоматизация сценария авторизации на портале</li>
    <li>Выход с учетной записи, закрытие объекта драйвера</li>
</ol>
<p>Справочная информация:</p>
<p><a href="https://habr.com/ru/post/502292/">https://habr.com/ru/post/502292/</a></p>
<p><a href="https://chromedriver.chromium.org/downloads">https://chromedriver.chromium.org/downloads</a></p>

<br/>
<strong>Работа с элементами:</strong>

```
WebElement userName = driver.findElement(By.cssSelector("input#username"));
//или
WebElement userName = driver.findElement(By.cssSelector("#username"));
Xpath локаторы (абсолютный и относительный путь)
WebElement userName = driver.findElement(By.xpath("html/body/div/div/form/input"));
WebElement userName = driver.findElement(By.xpath("//input"));
```