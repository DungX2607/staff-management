package com.dungnx.staffmanagement.service;

import com.dungnx.staffmanagement.entity.Staff;
import com.dungnx.staffmanagement.form.staff.CreateStaffForm;
import com.dungnx.staffmanagement.form.staff.StaffFilterForm;
import com.dungnx.staffmanagement.form.staff.UpdateStaffForm;
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
