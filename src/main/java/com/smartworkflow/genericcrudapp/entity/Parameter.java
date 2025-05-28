package com.smartworkflow.genericcrudapp.entity;

import com.smartworkflow.genericcrudapp.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parameter")
@Getter
@Setter
public class Parameter extends BaseEntity {

    @Column(name = "param_key", nullable = false, unique = true)
    private String key;

    @Column(name = "param_value", nullable = false)
    private String value;
}
