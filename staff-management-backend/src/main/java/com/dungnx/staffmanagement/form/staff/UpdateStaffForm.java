package com.dungnx.staffmanagement.form.staff;

import com.dungnx.staffmanagement.entity.Gender;
import com.dungnx.staffmanagement.entity.StaffRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateStaffForm {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private StaffRole role;
    private int yearOfBirth;
}
