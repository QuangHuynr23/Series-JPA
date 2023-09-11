package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.BuildingEntity1;
import com.laptrinhjavaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<BuildingSearchResponse> findAll() {
//        List<BuildingFilter> results = new ArrayList<>();
        List<BuildingSearchResponse> results = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
        for(BuildingEntity item : buildingEntities){
            BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
            buildingSearchResponse.setName(item.getName());
//            buildingSearchResponse.setAddress(item.getStreet()+" - " + item.getWard());
            results.add(buildingSearchResponse);
        }
        return results;
    }
}
