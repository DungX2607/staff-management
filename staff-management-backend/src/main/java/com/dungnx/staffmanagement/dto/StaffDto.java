package com.dungnx.salesmanagement.dto;

import com.dungnx.salesmanagement.entity.Gender;
import com.dungnx.salesmanagement.entity.StaffRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffDto {
    private int id;

    private String fullName;

    private Gender gender;

    private int namSinh;

    private StaffRole role;

    private int chiNhanhID;
}
