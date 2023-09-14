package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
@Primary

public class BuildingRepositoryImpl implements BuildingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll() {
//        JPQL
        Query query = entityManager.createNamedQuery("BuildingEntity.Find_All",BuildingEntity.class);
        return query.getResultList();

//        SQL native
//        String sql ="select * from javaweb92023.building";
//        Query query = entityManager.createNativeQuery(sql,BuildingEntity.class);
//        return query.getResultList();
    }

    @Override
    public BuildingEntity findById(Long id) {
//        SQL native
        String sql ="select * from javaweb92023.building where id = "+id+" ";
        Query query = entityManager.createNativeQuery(sql,BuildingEntity.class);
        return (BuildingEntity) query.getSingleResult();
    }
}
