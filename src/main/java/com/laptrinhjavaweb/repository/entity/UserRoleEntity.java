package com.laptrinhjavaweb.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "userrole")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name ="roleid")
    private RoleEntity roleEntity;


}
