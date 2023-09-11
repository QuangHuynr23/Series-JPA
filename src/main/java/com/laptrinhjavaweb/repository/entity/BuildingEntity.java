package com.laptrinhjavaweb.repository.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberofbasement")
    private Integer numberOfBasement;

    @OneToMany(mappedBy = "buildingEntity")
    private List<RentAreaEntity> rentAreaEntityList= new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RentAreaEntity> getRentAreaEntityList() {
        return rentAreaEntityList;
    }

    public void setRentAreaEntityList(List<RentAreaEntity> rentAreaEntityList) {
        this.rentAreaEntityList = rentAreaEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }
}
