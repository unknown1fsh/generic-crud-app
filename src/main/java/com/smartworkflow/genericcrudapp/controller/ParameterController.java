package com.smartworkflow.genericcrudapp.controller;

import com.smartworkflow.genericcrudapp.dto.ParameterDTO;
import com.smartworkflow.genericcrudapp.service.ParameterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {

    private final ParameterService service;

    public ParameterController(ParameterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ParameterDTO> save(@Valid @RequestBody ParameterDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParameterDTO> update(@PathVariable @NonNull Long id, @Valid @RequestBody ParameterDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NonNull Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ParameterDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParameterDTO> getById(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/key/{key}")
    public ResponseEntity<ParameterDTO> getByKey(@PathVariable String key) {
        return ResponseEntity.ok(service.getByKey(key));
    }

    @GetMapping("/value/{key}")
    public ResponseEntity<String> getValue(@PathVariable String key) {
        return ResponseEntity.ok(service.getValue(key));
    }
}

