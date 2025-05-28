package com.smartworkflow.genericcrudapp.service.impl;

import com.smartworkflow.genericcrudapp.repository.ParameterRepository;
import com.smartworkflow.genericcrudapp.service.ParameterService;
import org.springframework.stereotype.Service;

@Service
public class ParameterServiceImpl implements ParameterService {

    private final ParameterRepository repository;

    public ParameterServiceImpl(ParameterRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getValue(String key) {
        return repository.findByKey(key)
                .map(p -> p.getValue())
                .orElseThrow(() -> new RuntimeException("Parametre bulunamadı: " + key));
    }
}
