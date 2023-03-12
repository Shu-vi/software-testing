package org.Generalov.database.entity;


import java.util.Objects;

public class User {
    private Integer id;
    private String login;
    private String password;
    private Boolean isOnline;

    public User(Integer id, String login, String password, Boolean isOnline) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isOnline = isOnline;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login)
                && Objects.equals(password, user.password) && Objects.equals(isOnline, user.isOnline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, isOnline);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getOnline() {
        return isOnline;
    }
}
