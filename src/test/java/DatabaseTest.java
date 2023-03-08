import org.Generalov.database.Database;
import org.Generalov.service.User;
import org.Generalov.utils.GetProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DatabaseTest {
    private Database database = Database.getObjectDatabaseControl();

    @BeforeAll
    public static void start() {
        try {
            SqlRunner.executeSqlFile(GetProperties.PATH_TO_INIT_SQL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Проверка существования пользователя, негативный тест
     */
    @Test
    public void checkUserExists1() {
        try {
            Assertions.assertNotNull(database.getUserByLogin("correct_email@mail.ru"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Проверка подключения к бд. Позитивный тест.
     */
    @Test
    public void checkConnection() {
        try {
            Assertions.assertTrue(database.isConnect());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Проверка добавления данных в бд. Один позитивный кейс.
     */
    @Test
    public void checkAddingData() {
        Assertions.assertTrue(User.registration("correct_email@mail.ru", "12345678"));
    }

    /**
     * Проверка существования пользователя, позитивный тест тест
     */
    @Test
    public void checkUserExists2() {
        try {
            Assertions.assertNotNull(database.getUserByLogin("correct_email@mail.ru"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Проверка выхода с учетной записи. Один позитивный тест.
     * Предварительные условия: нужно залогиниться
     */
    @Test
    public void checkLogout1() {
        /**
         * Предварительные условия
         */
        User.login("correct_email@mail.ru", "12345678");
        /**
         * Тест
         */
        Assertions.assertTrue(User.logout("correct_email@mail.ru"));
    }

    /**
     * Проверка выхода с учетной записи. Один негативный тест.
     * Предварительные условия: нужно не быть залогиненым
     */
    @Test
    public void checkLogout2() {
        Assertions.assertFalse(User.logout("correct_email@mail.ru"));
    }

    /**
     * Удаление всех таблиц бд
     */
    @AfterAll
    public static void finish() {
        try {
            SqlRunner.executeSqlFile(GetProperties.PATH_TO_CLEAR_SQL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
