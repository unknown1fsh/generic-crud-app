package com.smartworkflow.genericcrudapp.service;

import com.smartworkflow.genericcrudapp.dto.GenericDTO;
import org.springframework.lang.NonNull;

import java.util.List;

public interface GenericService {
    GenericDTO save(GenericDTO dto);
    GenericDTO update(@NonNull Long id, GenericDTO dto);
    void delete(@NonNull Long id);
    GenericDTO getById(@NonNull Long id);
    List<GenericDTO> findAll();
    List<GenericDTO> getByEntityType(String entityType);
    List<GenericDTO> search(String entityType, String key, String value);
}
