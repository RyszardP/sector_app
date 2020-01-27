package com.ryszard.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="user_brigade")
public class UserBrigade {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_brigade_id")
    private Long userBrigadeId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="brigade_id")
    private Long brigadeId;

    @Column(name="date_start")
    private Timestamp dateStart;

    @Column(name="date_finish")
    private Timestamp dateFinish;

    public UserBrigade() {
    }

    public UserBrigade(Long userBrigadeId, Long userId, Long brigadeId, Timestamp dateStart, Timestamp dateFinish) {
        this.userBrigadeId = userBrigadeId;
        this.userId = userId;
        this.brigadeId = brigadeId;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public Long getUserBrigadeId() {
        return userBrigadeId;
    }

    public void setUserBrigadeId(Long userBrigadeId) {
        this.userBrigadeId = userBrigadeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(Long brigadeId) {
        this.brigadeId = brigadeId;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public void setDateStart(Timestamp dateStart) {
        this.dateStart = dateStart;
    }

    public Timestamp getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Timestamp dateFinish) {
        this.dateFinish = dateFinish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBrigade)) return false;
        UserBrigade that = (UserBrigade) o;
        return Objects.equals(userBrigadeId, that.userBrigadeId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(brigadeId, that.brigadeId) &&
                Objects.equals(dateStart, that.dateStart) &&
                Objects.equals(dateFinish, that.dateFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userBrigadeId, userId, brigadeId, dateStart, dateFinish);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
