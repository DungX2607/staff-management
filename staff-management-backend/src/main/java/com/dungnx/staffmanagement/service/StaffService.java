package com.dungnx.salesmanagement.service;

import com.dungnx.salesmanagement.entity.Staff;
import com.dungnx.salesmanagement.form.staff.CreateStaffForm;
import com.dungnx.salesmanagement.form.staff.StaffFilterForm;
import com.dungnx.salesmanagement.form.staff.UpdateStaffForm;
import com.dungnx.salesmanagement.repository.IStaffRepository;
import com.dungnx.salesmanagement.specification.Staff.StaffSpecification;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StaffService implements IStaffService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IStaffRepository staffRepository;

    public Page<Staff> getAllStaffs(Pageable pageable, String search, StaffFilterForm filterForm) {

        Specification<Staff> where = StaffSpecification.buildWhere(search, filterForm);
        return staffRepository.findAll(where, pageable);
    }

    public Staff getStaffById(int id) {
        return staffRepository.findById(id).get();
    }

    @Transactional
    public void createStaff(CreateStaffForm form) {
        // bỏ qua trường Id
        TypeMap<CreateStaffForm, Staff> typeMap = modelMapper.getTypeMap(CreateStaffForm.class, Staff.class);
        if (typeMap == null) { // nếu không được thêm
            // bỏ qua trường
            modelMapper.addMappings(new PropertyMap<CreateStaffForm, Staff>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }

        // chuyển đổi form thành entity
        Staff staff = modelMapper.map(form, Staff.class);

        staffRepository.save(staff);
    }

    @Transactional
    public void updateStaff(UpdateStaffForm form) {
        // chuyển form thành entity
        Staff staff = modelMapper.map(form, Staff.class);

//        Staff staff = staffRepository.findById(staff.getId()).get();

        staffRepository.save(staff);
    }

    public boolean isStaffExistsById(Integer id) {
        return staffRepository.existsById(id);
    }

    @Transactional
    public void deleteStaff(Integer id) {
        Staff staff = getStaffById(id);

        staffRepository.deleteById(id);
    }
}
