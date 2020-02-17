package com.ryszard.domain.hibernate;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Objects;


public class User {

    private Long userId;

    @NotNull(message = "Is required")
    @Size(min=1)
    private String userName;

    @NotNull(message = "Is required")
    @Size(min=1)
    private String userSurname;

    private String login;

    private String password;

    private Timestamp birthDate;

    private Long userSectorId;

    public User() {
    }

    public User(Long userId, String userName, String userSurname, String login, String password, Timestamp birthDate, Long userSectorId) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.userSectorId = userSectorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Long getUserSectorId() {
        return userSectorId;
    }

    public void setUserSectorId(Long userSectorId) {
        this.userSectorId = userSectorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userSurname, user.userSurname) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(userSectorId, user.userSectorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userSurname, login, password, birthDate, userSectorId);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
