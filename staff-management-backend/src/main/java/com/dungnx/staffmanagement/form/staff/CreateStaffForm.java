package com.dungnx.salesmanagement.form.staff;

import com.dungnx.salesmanagement.entity.Gender;
import com.dungnx.salesmanagement.entity.StaffRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateStaffForm {
    private String firstName;
    private String lastName;
    private Gender gender;
    private StaffRole role;
    private int namSinh;
}
