package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.model.dto.RentAreaDTO;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;
import com.laptrinhjavaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentAreaAPI {

    @Autowired
    private BuildingService buildingService;

     @GetMapping("/api/rentareas")
    public List<RentAreaDTO> getRentArea(@RequestParam(value = "buildingid", required = false) Long buildingId){

        return buildingService.findRentAreaByBuilding(buildingId);
     }
}
