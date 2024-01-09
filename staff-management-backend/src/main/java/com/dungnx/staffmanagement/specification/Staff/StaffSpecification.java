package com.dungnx.salesmanagement.specification.Staff;

import com.dungnx.salesmanagement.entity.Staff;
import com.dungnx.salesmanagement.form.staff.StaffFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class StaffSpecification {
    @SuppressWarnings("deprecation")
    public static Specification<Staff> buildWhere(String search, StaffFilterForm filterForm) {

        Specification<Staff> where = null;

        if (!StringUtils.isEmpty(search)) {
            search = search.trim();
            CustomStaffSpecification fullName = new CustomStaffSpecification("fullName", search);
            where = Specification.where(fullName);
        }

        // if there is filter by min dongia
        if (filterForm != null && filterForm.getMinID() != null) {
            CustomStaffSpecification minId = new CustomStaffSpecification("minSoLuongNhanVien", filterForm.getMinID());
            if (where == null) {
                where = minId;
            } else {
                where = where.and(minId);
            }
        }

        // if there is filter by max dongia
        if (filterForm != null && filterForm.getMaxID() != null) {
            CustomStaffSpecification maxId = new CustomStaffSpecification("maxSoLuongNhanVien", filterForm.getMaxID());
            if (where == null) {
                where = maxId;
            } else {
                where = where.and(maxId);
            }
        }

        return where;
    }
}

