package com.dungnx.staffmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "Staff")
@Data
@NoArgsConstructor
public class Staff {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Formula(" concat(firstName, ' ', lastName) ")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "ENUM('MALE', 'FEMALE', 'OTHER')")
    private Gender gender;

    @Column(name = "`role`", columnDefinition = "ENUM('PARTTIME', 'FULLTIME')")
    @Enumerated(EnumType.STRING)
    private StaffRole role;

    @Column(name = "yearOfBirth")
    private int yearOfBirth;

}
