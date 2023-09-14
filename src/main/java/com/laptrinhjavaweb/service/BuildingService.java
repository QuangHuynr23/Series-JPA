package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.filter.BuildingFilter;
import com.laptrinhjavaweb.model.dto.RentAreaDTO;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;

import java.util.List;

public interface BuildingService {
    List<BuildingSearchResponse> findAll();
    List<RentAreaDTO> findRentAreaByBuilding(Long buildingId);
}
