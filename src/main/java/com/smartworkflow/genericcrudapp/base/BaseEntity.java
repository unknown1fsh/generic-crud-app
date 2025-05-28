package com.smartworkflow.genericcrudapp.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(updatable = false)
    protected LocalDateTime createdAt = LocalDateTime.now();

    protected LocalDateTime updatedAt;

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
