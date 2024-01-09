package com.dungnx.salesmanagement.repository;

import com.dungnx.salesmanagement.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IStaffRepository extends JpaRepository<Staff, Integer>, JpaSpecificationExecutor<Staff> {
}
