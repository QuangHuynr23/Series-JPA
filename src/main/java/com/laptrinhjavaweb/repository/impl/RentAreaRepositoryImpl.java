package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RentAreaEntity> findByBuilding(Long buildingId) {
//        JPQL
        String sql = "FROM RentAreaEntity Where buildingEntity.id = "+buildingId+"";
        Query query = entityManager.createQuery(sql, RentAreaEntity.class);
        return query.getResultList();
    }
}
