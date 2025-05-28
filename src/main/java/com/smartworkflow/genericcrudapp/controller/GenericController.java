package com.smartworkflow.genericcrudapp.controller;

import com.smartworkflow.genericcrudapp.dto.GenericDTO;
import com.smartworkflow.genericcrudapp.service.GenericService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<GenericDTO> save(@RequestBody GenericDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<GenericDTO>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(service.getByEntityType(type));
    }
}
