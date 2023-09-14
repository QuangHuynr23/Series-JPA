package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.RentAreaConverter;
import com.laptrinhjavaweb.model.dto.RentAreaDTO;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingJdbc;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;
import com.laptrinhjavaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

//    @Autowired
//    private BuildingJdbc buildingJdbc;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private RentAreaConverter rentAreaConverter;
    @Override
    public List<BuildingSearchResponse> findAll() {
//        List<BuildingFilter> results = new ArrayList<>();
        List<BuildingSearchResponse> results = new ArrayList<>();
//        List<BuildingEntity> buildingEntities = buildingJdbc.findAll();
        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
        for(BuildingEntity item : buildingEntities){
            BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
            buildingSearchResponse.setName(item.getName());
//            buildingSearchResponse.setAddress(item.getStreet()+" - " + item.getWard());
            results.add(buildingSearchResponse);
        }
        return results;
    }

    @Override
    public List<RentAreaDTO> findRentAreaByBuilding(Long buildingId) {
        List<RentAreaDTO> results = new ArrayList<>();
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId);
        List<RentAreaEntity> rentAreaEntities = buildingEntity.getRentAreaEntity();
        results = rentAreaEntities.stream().map(item-> rentAreaConverter.converterEntityToDTO(item)).collect(Collectors.toList());
        return results;
    }
}
