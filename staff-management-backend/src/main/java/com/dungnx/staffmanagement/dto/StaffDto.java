package com.dungnx.staffmanagement.dto;

import com.dungnx.staffmanagement.entity.Gender;
import com.dungnx.staffmanagement.entity.StaffRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffDto {
    private int id;

    private String fullName;

    private Gender gender;

    private int yearOfBirth;

    private StaffRole role;
}
