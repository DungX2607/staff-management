package com.dungnx.salesmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "Manager")
@Data
@NoArgsConstructor
public class Manager {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Formula("concat(firstName, ' ', lastName) ")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "ENUM('MALE', 'FEMALE', 'OTHER')")
    private Gender gender;

    @Column(name = "namSinh")
    private int namSinh;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 800, nullable = false)
    private String password;

    @Column(name = "`role`", columnDefinition = "ENUM('ADMIN', 'SALE', 'IT', 'SECURITY')")
    @Enumerated(EnumType.STRING)
    private ManagerRole role;
}
