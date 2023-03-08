import org.Generalov.utils.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ValidateTest {
    /**
     * Валидация логина, позитивный кейс
     */
    @Test
    public void loginValidate1() {
        String login = "correct_login@mail.ru";
        Assertions.assertTrue(Validation.checkLogin(login));
    }

    /**
     * Валидация логина, негативный кейс
     */
    @Test
    public void loginValidate2() {
        String login = "*incorrect_login@mail.ru";
        Assertions.assertFalse(Validation.checkLogin(login));
    }

    /**
     * Валидация пароля, позитивный кейс
     */
    @Test
    public void passwordValidate1() {
        String password = "jlwn@wer%.a723d";
        Assertions.assertTrue(Validation.checkPassword(password));
    }

    /**
     * Валидация пароля, негативный кейс
     */
    @Test
    public void passwordValidate2() {
        String password = "ars4";
        Assertions.assertFalse(Validation.checkPassword(password));
    }
}
