package com.smartworkflow.genericcrudapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericDTO {
    private Long id;
    private String entityType;
    private String entityKey;
    private String entityValue;
}
