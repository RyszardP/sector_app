package com.ryszard.domain.vo;

import java.sql.Timestamp;
import java.util.Objects;

public class User {

    private int userId;

    private String userName;

    private String userSurname;

    private String login;

    private String password;

    private Timestamp birthDate;

    public User() {
    }


    public User(int userId, String userName, String userSurname, String login, String password, Timestamp birthDate) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userSurname, user.userSurname) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userSurname, login, password, birthDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
