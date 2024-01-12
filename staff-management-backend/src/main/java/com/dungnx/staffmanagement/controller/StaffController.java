package com.dungnx.staffmanagement.controller;

import com.dungnx.staffmanagement.dto.StaffDto;
import com.dungnx.staffmanagement.entity.Staff;
import com.dungnx.staffmanagement.form.staff.CreateStaffForm;
import com.dungnx.staffmanagement.form.staff.StaffFilterForm;
import com.dungnx.staffmanagement.form.staff.UpdateStaffForm;
import com.dungnx.staffmanagement.service.IStaffService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "api/v1/staff")
public class StaffController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IStaffService staffService;

    @GetMapping()
    public Page<StaffDto> getAllStaffs(
            Pageable pageable,
            @RequestParam(value = "search", required = false) String search,
            StaffFilterForm filterForm) {

        Page<Staff> entityPages = staffService.getAllStaffs(pageable, search, filterForm);

        // convert entities --> dtos
        List<StaffDto> dtos = modelMapper.map(
                entityPages.getContent(),
                new TypeToken<List<StaffDto>>() {}.getType());

        Page<StaffDto> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

        return dtoPages;
    }

    @GetMapping(value = "/{id}")
    public StaffDto getStaffById(@PathVariable(name = "id") int id) {
        Staff entity = staffService.getStaffById(id);

        // convert entity to dto
        StaffDto dto = modelMapper.map(entity, StaffDto.class);

//        dto.add(linkTo(methodOn(StaffController.class).getStaffById(id)).withSelfRel());

        return dto;
    }

    @PostMapping()
    public void createStaff(@RequestBody CreateStaffForm form) {
        staffService.createStaff(form);
    }

    @PutMapping(value = "/{id}")
    public void updateStaff(
//			@StaffIdExists
            @PathVariable(name = "id") int id,
            @RequestBody UpdateStaffForm form) {
        form.setId(id);
        staffService.updateStaff(form);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStaff(@PathVariable(name = "id") int id) {
        staffService.deleteStaff(id);
    }
}
