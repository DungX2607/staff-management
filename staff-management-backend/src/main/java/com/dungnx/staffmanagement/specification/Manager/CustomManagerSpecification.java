package com.dungnx.staffmanagement.specification.Manager;

import com.dungnx.staffmanagement.entity.Manager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomManagerSpecification implements Specification<Manager> {

    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(
            Root<Manager> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {

        if (field.equalsIgnoreCase("username")) {
            return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%");
        }

        if (field.equalsIgnoreCase("minID")) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
        }

        if (field.equalsIgnoreCase("maxID")) {
            return criteriaBuilder.lessThanOrEqualTo(root.get("id"), value.toString());
        }

        return null;
    }
}