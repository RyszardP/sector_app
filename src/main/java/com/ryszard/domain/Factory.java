package com.ryszard.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="factory")
public class Factory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="factory_id")
    private Long factoryId;

    @Column(name="factory_name")
    private String factoryName;

    public Factory() {
    }

    public Factory(Long factoryId, String factoryName) {
        this.factoryId = factoryId;
        this.factoryName = factoryName;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factory)) return false;
        Factory factory = (Factory) o;
        return Objects.equals(factoryId, factory.factoryId) &&
                Objects.equals(factoryName, factory.factoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factoryId, factoryName);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}