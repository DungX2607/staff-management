package com.dungnx.staffmanagement.dto;

import com.dungnx.staffmanagement.entity.Gender;
import com.dungnx.staffmanagement.entity.ManagerRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ManagerDto {
    private int id;

    private String username;

    private String fullName;

    private Gender gender;

    private int yearOfBirth;

    private ManagerRole role;
}
