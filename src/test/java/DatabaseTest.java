import org.Generalov.database.dao.UserDao;
import org.Generalov.database.entity.User;
import org.Generalov.utils.SpringConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class DatabaseTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${initSql}")
    private String initSql;
    @Value("${dataSql}")
    private String dataSql;
    @Autowired
    private UserDao userDao;
    private User user;

    {
        user = new User(1, "wsfdsd@stud.kpfu.ru", "6dg23dv45", false);
    }

    @BeforeEach
    public void setUp() {
        ResourceDatabasePopulator tables = new ResourceDatabasePopulator();
        tables.addScript(new ClassPathResource(initSql));
        tables.addScript(new ClassPathResource(dataSql));
        tables.execute(Objects.requireNonNull(jdbcTemplate.getDataSource()));
    }

    @AfterEach
    public void tearDown() {
        JdbcTestUtils.dropTables(jdbcTemplate, "users");
    }


    @Test
    public void getUsers() {
        List<User> usersCurrent = userDao.getUsers();
        List<User> usersExpected = new ArrayList<>();
        usersExpected.add(new User(4, "correct1@mail.ru", "sdkcfbk32%as.", false));
        usersExpected.add(new User(9, "correct2@google.com", "sdkcsdffbk32%as.", false));
        usersExpected.add(new User(233, "correct3@yandex.ru", "sdkc235fbk32%as.", false));
        Assertions.assertEquals(usersExpected, usersCurrent);
    }

    @Test
    public void countingUsers() {
        int currentCount = userDao.getUsers().size();
        Assertions.assertEquals(3, currentCount);
    }

    @Test
    public void registrationUser() {
        userDao.addUser(user);
        User currentUser = userDao.getUserByLogin(user.getLogin());
        Assertions.assertEquals(user, currentUser);
    }

    @Test
    public void deleteUser() {
        userDao.deleteUserById(user.getId());
        user = userDao.getUserByLogin(user.getLogin());
        Assertions.assertNull(user);
    }

}
