package com.smartworkflow.genericcrudapp.service.impl;

import com.smartworkflow.genericcrudapp.dto.GenericDTO;
import com.smartworkflow.genericcrudapp.entity.GenericEntity;
import com.smartworkflow.genericcrudapp.exception.EntityNotFoundException;
import com.smartworkflow.genericcrudapp.mapper.GenericMapper;
import com.smartworkflow.genericcrudapp.repository.GenericRepository;
import com.smartworkflow.genericcrudapp.service.GenericService;
import com.smartworkflow.genericcrudapp.specification.GenericSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public GenericDTO save(GenericDTO dto) {
        GenericEntity entity = mapper.toEntity(dto);
        GenericEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public GenericDTO update(@NonNull Long id, GenericDTO dto) {
        GenericEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kayıt bulunamadı: " + id));
        
        entity.setEntityType(dto.getEntityType());
        entity.setEntityKey(dto.getEntityKey());
        entity.setEntityValue(dto.getEntityValue());
        
        GenericEntity updated = repository.save(entity);
        return mapper.toDto(updated);
    }

    @Override
    @Transactional
    public void delete(@NonNull Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Kayıt bulunamadı: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public GenericDTO getById(@NonNull Long id) {
        GenericEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kayıt bulunamadı: " + id));
        return mapper.toDto(entity);
    }

    @Override
    public List<GenericDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GenericDTO> getByEntityType(String entityType) {
        return repository.findByEntityType(entityType)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<GenericDTO> search(String entityType, String key, String value) {
        Specification<GenericEntity> spec = GenericSpecification.search(entityType, key, value);
        return repository.findAll(spec)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
