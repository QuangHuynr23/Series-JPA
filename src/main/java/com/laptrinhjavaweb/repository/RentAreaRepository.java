package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.repository.entity.RentAreaEntity;

import java.util.List;

public interface RentAreaRepository {
    List<RentAreaEntity> findByBuilding(Long buildingId);
}
