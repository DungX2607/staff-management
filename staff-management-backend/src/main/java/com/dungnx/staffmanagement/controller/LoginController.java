package com.dungnx.staffmanagement.controller;

import java.security.Principal;

import com.dungnx.staffmanagement.dto.LoginInfoDto;
import com.dungnx.staffmanagement.entity.Manager;
import com.dungnx.staffmanagement.service.IManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private IManagerService managerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<?> login(Principal principal) {
        String username = principal.getName();
        Manager entity = managerService.getManagerByUsername(username);

        LoginInfoDto dto = modelMapper.map(entity, LoginInfoDto.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}