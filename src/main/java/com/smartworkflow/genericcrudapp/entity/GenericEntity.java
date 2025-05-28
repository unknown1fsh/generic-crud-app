package com.smartworkflow.genericcrudapp.entity;

import com.smartworkflow.genericcrudapp.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "generic_data")
@Getter
@Setter
public class GenericEntity extends BaseEntity {

    @Column(nullable = false)
    private String entityType;

    @Column(nullable = false)
    private String entityKey;

    @Column(columnDefinition = "TEXT")
    private String entityValue;
}
