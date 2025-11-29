package com.smartworkflow.genericcrudapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericDTO {
    private Long id;
    
    @NotBlank(message = "Varlık tipi boş olamaz")
    @Size(max = 100, message = "Varlık tipi en fazla 100 karakter olabilir")
    private String entityType;
    
    @NotBlank(message = "Anahtar boş olamaz")
    @Size(max = 100, message = "Anahtar en fazla 100 karakter olabilir")
    private String entityKey;
    
    @NotBlank(message = "Değer boş olamaz")
    private String entityValue;
}
