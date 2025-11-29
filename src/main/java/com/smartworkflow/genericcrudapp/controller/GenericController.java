package com.smartworkflow.genericcrudapp.controller;

import com.smartworkflow.genericcrudapp.dto.GenericDTO;
import com.smartworkflow.genericcrudapp.service.GenericService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generic")
public class GenericController {

    private final GenericService service;

    public GenericController(GenericService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GenericDTO> save(@Valid @RequestBody GenericDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericDTO> update(@PathVariable @NonNull Long id, @Valid @RequestBody GenericDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NonNull Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<GenericDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GenericDTO> getById(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<GenericDTO>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(service.getByEntityType(type));
    }

    @GetMapping("/search")
    public ResponseEntity<List<GenericDTO>> search(
            @RequestParam(required = false) String entityType,
            @RequestParam(required = false) String key,
            @RequestParam(required = false) String value) {
        return ResponseEntity.ok(service.search(entityType, key, value));
    }
}
