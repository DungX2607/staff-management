package com.dungnx.staffmanagement.specification.Staff;

import com.dungnx.staffmanagement.entity.Staff;
import com.dungnx.staffmanagement.form.staff.StaffFilterForm;
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

        // if there is filter by minID
        if (filterForm != null && filterForm.getMinID() != null) {
            CustomStaffSpecification minId = new CustomStaffSpecification("minID", filterForm.getMinID());
            if (where == null) {
                where = minId;
            } else {
                where = where.and(minId);
            }
        }

        // if there is filter by maxID
        if (filterForm != null && filterForm.getMaxID() != null) {
            CustomStaffSpecification maxId = new CustomStaffSpecification("maxID", filterForm.getMaxID());
            if (where == null) {
                where = maxId;
            } else {
                where = where.and(maxId);
            }
        }

        return where;
    }
}

