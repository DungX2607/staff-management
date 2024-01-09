package com.dungnx.salesmanagement.specification.Staff;

import com.dungnx.salesmanagement.entity.Staff;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomStaffSpecification implements Specification<Staff> {

    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(
            Root<Staff> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder) {

        if (field.equalsIgnoreCase("fullName")) {
            return criteriaBuilder.like(root.get("fullName"), "%" + value.toString() + "%");
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
