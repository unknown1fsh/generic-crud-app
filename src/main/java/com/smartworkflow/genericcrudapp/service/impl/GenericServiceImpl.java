package com.smartworkflow.genericcrudapp.service.impl;

import com.smartworkflow.genericcrudapp.dto.GenericDTO;
import com.smartworkflow.genericcrudapp.entity.GenericEntity;
import com.smartworkflow.genericcrudapp.mapper.GenericMapper;
import com.smartworkflow.genericcrudapp.repository.GenericRepository;
import com.smartworkflow.genericcrudapp.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenericServiceImpl implements GenericService {

    private final GenericRepository repository;
    private final GenericMapper mapper;

    public GenericServiceImpl(GenericRepository repository, GenericMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public GenericDTO save(GenericDTO dto) {
        GenericEntity entity = mapper.toEntity(dto);
        GenericEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<GenericDTO> getByEntityType(String entityType) {
        return repository.findByEntityType(entityType)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
