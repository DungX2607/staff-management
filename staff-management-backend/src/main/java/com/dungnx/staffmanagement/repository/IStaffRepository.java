package com.dungnx.staffmanagement.repository;

import com.dungnx.staffmanagement.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IStaffRepository extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff> {
}
