package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.model.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.model.dto.BuildingDTO;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.customexception.FieldRequiredException;
import com.laptrinhjavaweb.filter.BuildingFilter;
import com.laptrinhjavaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;


    @GetMapping
    public List<BuildingSearchResponse> findAll(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "numberofbasement", required = false) Integer numberOfBasement,
                                                    @RequestParam(value = "types", required = false) List<String> types) {
//        List<BuildingSearchResponse> results = new ArrayList<>();
//        List<BuildingFilter> buildingFilters = buildingService.findAll();
//        for(BuildingFilter item: buildingFilters){
//            BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
//            buildingSearchResponse.setName(item.getName());
//            buildingSearchResponse.setAddress(item.getAddress());
//            results.add(buildingSearchResponse);
//        }
        List<BuildingSearchResponse> results = buildingService.findAll();
        return results;
    }

    @PostMapping
    public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
                validateData(newBuilding);
                return newBuilding;
    }

    private void validateData(BuildingDTO newBuilding){
        if(newBuilding.getName()==null || newBuilding.getName().equals("") || newBuilding.getNumberOfBasement()==null){
            throw new FieldRequiredException("name or numberofbasement is required");
        }
    }


    @PutMapping
    public BuildingDTO updateBuilding(@RequestBody BuildingDTO updateBuilding) {
        return updateBuilding;
    }

    @DeleteMapping
    public void deleteBuilding(@RequestBody BuildingDTO deleteBuilding) {
        System.out.println("ok");
    }

    @PostMapping("/assignment")
    public void assignmentBuilding(@RequestBody AssignmentBuildingRequest assignmentBuildingRequest){
        System.out.println("ok");
    }
}
