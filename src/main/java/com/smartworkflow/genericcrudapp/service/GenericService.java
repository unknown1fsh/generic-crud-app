package com.smartworkflow.genericcrudapp.service;

import com.smartworkflow.genericcrudapp.dto.GenericDTO;

import java.util.List;

public interface GenericService {
    GenericDTO save(GenericDTO dto);
    List<GenericDTO> getByEntityType(String entityType);
}
