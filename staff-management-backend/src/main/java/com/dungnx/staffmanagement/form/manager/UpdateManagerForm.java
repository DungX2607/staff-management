package com.dungnx.staffmanagement.form.manager;

import com.dungnx.staffmanagement.entity.Gender;
import com.dungnx.staffmanagement.entity.ManagerRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateManagerForm {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int yearOfBirth;
    private String username;
    private String password;
    private ManagerRole role;
}
