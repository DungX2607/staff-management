package com.dungnx.salesmanagement.dto;

import com.dungnx.salesmanagement.entity.Gender;
import com.dungnx.salesmanagement.entity.ManagerRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
public class ManagerDto {
    private int id;

    private String username;

    private String fullName;

    private Gender gender;

    private int namSinh;

    private ManagerRole role;
}
