package com.ryszard.domain.hibernate;

import javax.persistence.*;

@Entity
@Table(name="sector")
public class Sector {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="sector_id")
    private Long sector_id;

    @Column(name="sector_name")
    private String sectorName;

    @Column(name="sector_department_id")
    private Long sector_factory;


    public Sector(Long sector_id, String sectorName, Long sector_factory) {
        this.sector_id = sector_id;
        this.sectorName = sectorName;
        this.sector_factory = sector_factory;
    }


    public Sector() {
    }

    public Long getSector_id() {
        return sector_id;
    }

    public void setSector_id(Long sector_id) {
        this.sector_id = sector_id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public Long getSector_factory() {
        return sector_factory;
    }

    public void setSector_factory(Long sector_factory) {
        this.sector_factory = sector_factory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sector)) return false;

        Sector sector = (Sector) o;

        if (getSector_id() != null ? !getSector_id().equals(sector.getSector_id()) : sector.getSector_id() != null)
            return false;
        if (getSectorName() != null ? !getSectorName().equals(sector.getSectorName()) : sector.getSectorName() != null)
            return false;
        return getSector_factory() != null ? getSector_factory().equals(sector.getSector_factory()) : sector.getSector_factory() == null;
    }

    @Override
    public int hashCode() {
        int result = getSector_id() != null ? getSector_id().hashCode() : 0;
        result = 31 * result + (getSectorName() != null ? getSectorName().hashCode() : 0);
        result = 31 * result + (getSector_factory() != null ? getSector_factory().hashCode() : 0);
        return result;
    }
}
