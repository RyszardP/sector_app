package com.ryszard.domain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="brigade")
public class Brigade {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="brigade_id")
    private Long brigadeId;

    @Column(name="brigade_type")
    private String brigadeType;

    public Brigade() {
    }

    public Brigade(String brigadeType) {
        this.brigadeType = brigadeType;
    }

    public Brigade(Long brigadeId, String brigadeType) {
        this.brigadeId = brigadeId;
        this.brigadeType = brigadeType;
    }

    public Long getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(Long brigadeId) {
        this.brigadeId = brigadeId;
    }

    public String getBrigadeType() {
        return brigadeType;
    }

    public void setBrigadeType(String brigadeType) {
        this.brigadeType = brigadeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brigade)) return false;
        Brigade brigade = (Brigade) o;
        return Objects.equals(brigadeId, brigade.brigadeId) &&
                Objects.equals(brigadeType, brigade.brigadeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brigadeId, brigadeType);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }



}