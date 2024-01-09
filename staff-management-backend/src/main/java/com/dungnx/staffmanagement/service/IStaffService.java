package com.dungnx.salesmanagement.service;

import com.dungnx.salesmanagement.entity.Staff;
import com.dungnx.salesmanagement.form.staff.CreateStaffForm;
import com.dungnx.salesmanagement.form.staff.StaffFilterForm;
import com.dungnx.salesmanagement.form.staff.UpdateStaffForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStaffService {
    public Page<Staff> getAllStaffs (Pageable pageable, String search, StaffFilterForm staffFilterForm);
    public Staff getStaffById(int id);

    public void createStaff(CreateStaffForm form);

    public void updateStaff(UpdateStaffForm form);

    public boolean isStaffExistsById(Integer id);

    public void deleteStaff(Integer id);
}
