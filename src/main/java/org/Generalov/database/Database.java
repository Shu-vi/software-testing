package org.Generalov.database;

import org.Generalov.entity.User;
import org.Generalov.utils.GetProperties;

import java.sql.*;

public class Database {
    private Connection connection;
    /**
     * Singleton класс
     */
    private volatile static Database database;

    private Database() {
    }

    /**
     * @return возвращает единственный экзэмпляр класса.
     */
    public static Database getObjectDatabaseControl() {
        if (database == null) {
            synchronized (Database.class) {
                if (database == null) {
                    database = new Database();
                }
            }
        }
        return database;
    }

    /**
     * Подключение к БД
     */

    private void connectToDB() throws SQLException {
        this.connection = DriverManager.getConnection(GetProperties.DB_URL, GetProperties.DB_USERNAME, GetProperties.DB_PASSWORD);

    }

    /**
     * Отключение БД
     */

    private void disconnectBD() throws SQLException {
        this.connection.close();
    }

    /**
     * @param user пользователь, которого нужно добавить.
     * @return true, если пользователь был успешно добавлен.
     */
    public Boolean addUser(User user) throws SQLException {
        connectToDB();
        PreparedStatement statement =
                connection.prepareStatement("INSERT INTO users(login, password, is_online) VALUES (?, ?, false)");
        statement.setString(1, user.getLogin());
        statement.setString(2, user.getPassword());
        int count = statement.executeUpdate();
        disconnectBD();
        return count > 0;
    }

    public Boolean userLogin(User user) throws SQLException {
        connectToDB();
        PreparedStatement statement =
                connection.prepareStatement("UPDATE users SET is_online = ? WHERE login = ?");
        statement.setBoolean(1, true);
        statement.setString(2, user.getLogin());
        int count = statement.executeUpdate();
        disconnectBD();
        return count > 0;
    }

    public Boolean userLogout(User user) throws SQLException {
        connectToDB();
        PreparedStatement statement =
                connection.prepareStatement("UPDATE users SET is_online = ? WHERE login = ?");
        statement.setBoolean(1, false);
        statement.setString(2, user.getLogin());
        int count = statement.executeUpdate();
        disconnectBD();
        return count > 0;
    }

    public User getUserByLogin(String login) throws SQLException {
        User user = null;
        connectToDB();
        PreparedStatement statement =
                connection.prepareStatement("SELECT * FROM users WHERE login = ?");
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            user = new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getBoolean(4));
        }
        disconnectBD();
        return user;
    }

    public Boolean isConnect() throws SQLException {
        return this.connection != null;
    }
}
