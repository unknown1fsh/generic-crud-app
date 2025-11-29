package com.smartworkflow.genericcrudapp.service;

import com.smartworkflow.genericcrudapp.dto.ParameterDTO;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ParameterService {
    ParameterDTO save(ParameterDTO dto);
    ParameterDTO update(@NonNull Long id, ParameterDTO dto);
    void delete(@NonNull Long id);
    ParameterDTO getById(@NonNull Long id);
    ParameterDTO getByKey(String key);
    List<ParameterDTO> findAll();
    String getValue(String key);
}
