package com.dungnx.salesmanagement.specification.Manager;

import com.dungnx.salesmanagement.entity.Manager;
import com.dungnx.salesmanagement.form.manager.ManagerFilterForm;

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

        // if there is filter by min dongia
        if (filterForm != null && filterForm.getMinID() != null) {
            CustomManagerSpecification minId = new CustomManagerSpecification("minSoLuongQuanLy", filterForm.getMinID());
            if (where == null) {
                where = minId;
            } else {
                where = where.and(minId);
            }
        }

        // if there is filter by max dongia
        if (filterForm != null && filterForm.getMaxID() != null) {
            CustomManagerSpecification maxId = new CustomManagerSpecification("maxSoLuongQuanLy", filterForm.getMaxID());
            if (where == null) {
                where = maxId;
            } else {
                where = where.and(maxId);
            }
        }

        return where;
    }
}
