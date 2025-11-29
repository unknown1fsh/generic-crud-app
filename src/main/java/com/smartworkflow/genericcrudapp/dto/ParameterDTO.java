package com.smartworkflow.genericcrudapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParameterDTO {
    private Long id;
    
    @NotBlank(message = "Parametre anahtarı boş olamaz")
    @Size(max = 100, message = "Parametre anahtarı en fazla 100 karakter olabilir")
    private String key;
    
    @NotBlank(message = "Parametre değeri boş olamaz")
    @Size(max = 255, message = "Parametre değeri en fazla 255 karakter olabilir")
    private String value;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

