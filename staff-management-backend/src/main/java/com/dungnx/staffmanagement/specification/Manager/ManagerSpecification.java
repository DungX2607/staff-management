package com.dungnx.staffmanagement.specification.Manager;

import com.dungnx.staffmanagement.entity.Manager;
import com.dungnx.staffmanagement.form.manager.ManagerFilterForm;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class ManagerSpecification {
    @SuppressWarnings("deprecation")
    public static Specification<Manager> buildWhere(String search, ManagerFilterForm filterForm) {

        Specification<Manager> where = null;

        if (!StringUtils.isEmpty(search)) {
            search = search.trim();
            CustomManagerSpecification username = new CustomManagerSpecification("username", search);
            where = Specification.where(username);
        }

        // if there is filter by minID
        if (filterForm != null && filterForm.getMinID() != null) {
            CustomManagerSpecification minId = new CustomManagerSpecification("minID", filterForm.getMinID());
            if (where == null) {
                where = minId;
            } else {
                where = where.and(minId);
            }
        }

        // if there is filter by maxID
        if (filterForm != null && filterForm.getMaxID() != null) {
            CustomManagerSpecification maxId = new CustomManagerSpecification("maxID", filterForm.getMaxID());
            if (where == null) {
                where = maxId;
            } else {
                where = where.and(maxId);
            }
        }

        return where;
    }
}
