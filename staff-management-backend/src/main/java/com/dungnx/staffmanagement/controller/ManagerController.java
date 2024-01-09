package com.dungnx.salesmanagement.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.dungnx.salesmanagement.dto.ManagerDto;
import com.dungnx.salesmanagement.entity.Manager;
import com.dungnx.salesmanagement.form.manager.CreateManagerForm;
import com.dungnx.salesmanagement.form.manager.ManagerFilterForm;
import com.dungnx.salesmanagement.form.manager.UpdateManagerForm;
import com.dungnx.salesmanagement.service.IManagerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/manager")
public class ManagerController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IManagerService managerService;

    @GetMapping()
    public Page<ManagerDto> getAllManagers(
            Pageable pageable,
            @RequestParam(value = "search", required = false) String search,
            ManagerFilterForm filterForm)
    {
        Page<Manager> entityPages = managerService.getAllManagers(pageable, search, filterForm);

        // convert entities --> dtos
        List<ManagerDto> dtos = modelMapper.map(
                entityPages.getContent(),
                new TypeToken<List<ManagerDto>>() {}.getType());

        Page<ManagerDto> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

        return dtoPages;
    }

    @GetMapping(value = "/{id}")
    public ManagerDto getManagerById(@PathVariable(name = "id") int id) {
        Manager entity = managerService.getManagerById(id);

        // convert entity to dto
        ManagerDto dto = modelMapper.map(entity, ManagerDto.class);


//        dto.add(linkTo(methodOn(ManagerController.class).getManagerById(id)).withSelfRel());

        return dto;
    }

    @GetMapping(value = "/user/{username}")
    public ManagerDto getManagerByUsername(@PathVariable(name = "username") String username) {
        Manager entity = managerService.getManagerByUsername(username);

        // convert entity to dto
        ManagerDto dto = modelMapper.map(entity, ManagerDto.class);


//        dto.add(linkTo(methodOn(ManagerController.class).getManagerByUsername(username)).withSelfRel());

        return dto;
    }

    @PostMapping()
    public void createManager(@RequestBody CreateManagerForm form) {
        managerService.createManager(form);
    }

    @PutMapping(value = "/{id}")
    public void updateManager(
//			@ManagerIdExists
            @PathVariable(name = "id") int id,
            @RequestBody UpdateManagerForm form) {
        form.setId(id);
        managerService.updateManager(form);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteManager(@PathVariable(name = "id") int id) {
        managerService.deleteManager(id);
    }
}