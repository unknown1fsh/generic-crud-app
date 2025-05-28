package com.smartworkflow.genericcrudapp.specification;

import com.smartworkflow.genericcrudapp.entity.GenericEntity;
import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification {

    public static Specification<GenericEntity> hasEntityType(String entityType) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("entityType"), entityType);
    }

    public static Specification<GenericEntity> hasKey(String key) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("entityKey"), "%" + key + "%");
    }
}
