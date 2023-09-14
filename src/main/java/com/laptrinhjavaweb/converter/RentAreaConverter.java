package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.model.dto.RentAreaDTO;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentAreaConverter {
    @Autowired
    private ModelMapper modelMapper;

    public RentAreaDTO converterEntityToDTO(RentAreaEntity rentAreaEntity){
        RentAreaDTO result = modelMapper.map(rentAreaEntity, RentAreaDTO.class);
        return result;
    }
}
