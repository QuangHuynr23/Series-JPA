package com.laptrinhjavaweb.repository.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "building")
@NamedQuery(name ="BuildingEntity.Find_All",query = "FROM BuildingEntity")
public class
BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberofbasement")
    private Integer numberOfBasement;

    @OneToMany(mappedBy = "buildingEntity", fetch = FetchType.LAZY)
    private List<RentAreaEntity> rentAreaEntity= new ArrayList<>();



}
