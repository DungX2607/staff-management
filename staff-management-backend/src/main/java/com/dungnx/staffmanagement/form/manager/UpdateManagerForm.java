package com.dungnx.salesmanagement.form.manager;

import com.dungnx.salesmanagement.entity.Gender;
import com.dungnx.salesmanagement.entity.ManagerRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateManagerForm {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int namSinh;
    private String username;
    private String password;
    private ManagerRole role;
}
