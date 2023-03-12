<h1 style="text-align: center;">Задание</h1>
<ol>
    <li>Подготовить пустую базу в @Before, очищать базу в  @After</li>
    <li>Заполнить данными с помощью <strong>ResourceDatabasePopulator</strong></li>
    <li>Инициализировать таблицы для интеграционного теста в методе <i>setUp()</i></li>
    <li>Реализовать тесты на <strong>Spring, JDBCTestUtils</strong> : удаляем таблицу, создаем новую</li>
</ol>
<h3>Тесты:</h3>
<ul>
    <li>получить пользователей</li>
    <li>подсчитать количество пользователей в базе</li>
    <li>заполнить данными (создать пользователя)</li>
    <li>Удалить данные (удалить пользователя)</li>
</ul>
<span>
    <span style="color: rgba(255, 255, 255, .5)">Использовать</span> 
    <strong>Assert.</strong><span style="color: aquamarine">assertThat</span> 
    для проверки результата
</span>
<p>
    <a style="background-color: rgb(255, 252, 211)" href="https://mywebcenter.ru/integracionnoe-testirovanie-i-spring-jdbc-4029/">
        Материал, необходимый для выполнения задания.
    </a>
</p>
<h1 style="text-align: center; text-transform: uppercase">Важно</h1>
<p>В задании требуется использовать Assert.assertThat, которого нет в junit5, поэтому я использовал Assertions.assertEquals, предварительно реализовав hashCode и equals, в необходимых классах.</p>
<p>Кроме того, в материале к заданию, один из тестов(который на подсчёт строк в таблице) проверяется через JDBCTestUtils, я же использовал метод своей БД, чтоб сделать это(нужно ведь тестировать методы БД, а не готовый класс, который считает количество строк в таблице?)</p>