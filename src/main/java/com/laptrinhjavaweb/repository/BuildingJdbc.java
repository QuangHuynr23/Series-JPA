package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingJdbc {
    List<BuildingEntity> findAll();
}
