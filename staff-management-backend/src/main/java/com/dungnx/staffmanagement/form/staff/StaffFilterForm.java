package com.dungnx.staffmanagement.form.staff;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffFilterForm {
    private Integer minID;

    private Integer maxID;
}
