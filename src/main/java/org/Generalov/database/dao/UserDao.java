package org.Generalov.database.dao;

import org.Generalov.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = "singleton")
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Добавление юзера

    public Boolean addUser(User user) {
        return jdbcTemplate.update("INSERT INTO users(login, password, is_online) VALUES (?, ?, ?)"
                , user.getLogin(), user.getPassword(), user.getOnline()) > 0;
    }

    //Логин

    public Boolean userLogin(User user) {
        return jdbcTemplate.update("UPDATE users SET is_online = ? WHERE login = ?",
                true, user.getLogin()) > 0;
    }

    //Логаут
    public Boolean userLogout(User user) {
        return jdbcTemplate.update("UPDATE users SET is_online = ? WHERE login = ?",
                false, user.getLogin()) > 0;
    }

    //Получение юзера по айди
    public User getUserByLogin(String login) {
        return jdbcTemplate.query("SELECT * FROM users WHERE login = ?", new UserRowMapper(), login)
                .stream().findFirst().orElse(null);
    }

    //Получаем всех юзеров
    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());
    }

    //Удаляем юзера по айди
    public Boolean deleteUserById(Integer id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id) > 0;
    }
}
