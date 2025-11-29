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

    public static Specification<GenericEntity> hasValue(String value) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("entityValue"), "%" + value + "%");
    }

    public static Specification<GenericEntity> search(String entityType, String key, String value) {
        Specification<GenericEntity> spec = null;
        
        if (entityType != null && !entityType.trim().isEmpty()) {
            spec = hasEntityType(entityType);
        }
        if (key != null && !key.trim().isEmpty()) {
            Specification<GenericEntity> keySpec = hasKey(key);
            spec = (spec == null) ? keySpec : spec.and(keySpec);
        }
        if (value != null && !value.trim().isEmpty()) {
            Specification<GenericEntity> valueSpec = hasValue(value);
            spec = (spec == null) ? valueSpec : spec.and(valueSpec);
        }
        
        return spec != null ? spec : (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
    }
}
