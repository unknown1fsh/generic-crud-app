package com.smartworkflow.genericcrudapp.repository;

import com.smartworkflow.genericcrudapp.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenericRepository extends JpaRepository<GenericEntity, Long>, JpaSpecificationExecutor<GenericEntity> {
    List<GenericEntity> findByEntityType(String entityType);
}
