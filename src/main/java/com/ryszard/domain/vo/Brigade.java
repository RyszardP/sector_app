package com.ryszard.domain.vo;

import java.util.Objects;

public class Brigade {

    private int brigadeId;

    private String brigadeType;

    public Brigade() {
    }


    public Brigade(int brigadeId, String brigadeType) {
        this.brigadeId = brigadeId;
        this.brigadeType = brigadeType;
    }

    public int getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(int brigadeId) {
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
        return "Brigade{" +
                "brigadeId=" + brigadeId +
                ", brigadeType='" + brigadeType + '\'' +
                '}';
    }
}
