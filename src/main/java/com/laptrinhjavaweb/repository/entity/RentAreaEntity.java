package com.laptrinhjavaweb.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rentarea")
public class RentAreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Integer value;

//    @Column(name = "buildingid")
//    private Long buildingId;

    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity buildingEntity;

}
