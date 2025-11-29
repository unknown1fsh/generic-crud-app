package com.smartworkflow.genericcrudapp.service.impl;

import com.smartworkflow.genericcrudapp.dto.ParameterDTO;
import com.smartworkflow.genericcrudapp.entity.Parameter;
import com.smartworkflow.genericcrudapp.exception.EntityNotFoundException;
import com.smartworkflow.genericcrudapp.repository.ParameterRepository;
import com.smartworkflow.genericcrudapp.service.ParameterService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParameterServiceImpl implements ParameterService {

    private final ParameterRepository repository;

    public ParameterServiceImpl(ParameterRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ParameterDTO save(ParameterDTO dto) {
        Parameter parameter = new Parameter();
        parameter.setKey(dto.getKey());
        parameter.setValue(dto.getValue());
        Parameter saved = repository.save(parameter);
        return toDto(saved);
    }

    @Override
    @Transactional
    public ParameterDTO update(@NonNull Long id, ParameterDTO dto) {
        Parameter parameter = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parametre bulunamadı: " + id));
        
        parameter.setKey(dto.getKey());
        parameter.setValue(dto.getValue());
        
        Parameter updated = repository.save(parameter);
        return toDto(updated);
    }

    @Override
    @Transactional
    public void delete(@NonNull Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Parametre bulunamadı: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public ParameterDTO getById(@NonNull Long id) {
        Parameter parameter = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parametre bulunamadı: " + id));
        return toDto(parameter);
    }

    @Override
    public ParameterDTO getByKey(String key) {
        Parameter parameter = repository.findByKey(key)
                .orElseThrow(() -> new EntityNotFoundException("Parametre bulunamadı: " + key));
        return toDto(parameter);
    }

    @Override
    public List<ParameterDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public String getValue(String key) {
        return repository.findByKey(key)
                .map(Parameter::getValue)
                .orElseThrow(() -> new EntityNotFoundException("Parametre bulunamadı: " + key));
    }

    private ParameterDTO toDto(Parameter parameter) {
        ParameterDTO dto = new ParameterDTO();
        dto.setId(parameter.getId());
        dto.setKey(parameter.getKey());
        dto.setValue(parameter.getValue());
        dto.setCreatedAt(parameter.getCreatedAt());
        dto.setUpdatedAt(parameter.getUpdatedAt());
        return dto;
    }
}
