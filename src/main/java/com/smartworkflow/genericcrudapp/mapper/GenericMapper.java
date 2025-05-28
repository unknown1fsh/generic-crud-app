package com.smartworkflow.genericcrudapp.mapper;

import com.smartworkflow.genericcrudapp.dto.GenericDTO;
import com.smartworkflow.genericcrudapp.entity.GenericEntity;
import org.springframework.stereotype.Component;

@Component
public class GenericMapper {

    public GenericDTO toDto(GenericEntity entity) {
        GenericDTO dto = new GenericDTO();
        dto.setId(entity.getId());
        dto.setEntityType(entity.getEntityType());
        dto.setEntityKey(entity.getEntityKey());
        dto.setEntityValue(entity.getEntityValue());
        return dto;
    }

    public GenericEntity toEntity(GenericDTO dto) {
        GenericEntity entity = new GenericEntity();
        entity.setId(dto.getId());
        entity.setEntityType(dto.getEntityType());
        entity.setEntityKey(dto.getEntityKey());
        entity.setEntityValue(dto.getEntityValue());
        return entity;
    }
}
