package com.dungnx.staffmanagement.repository;

import com.dungnx.staffmanagement.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IManagerRepository extends JpaRepository<Manager, Integer>, JpaSpecificationExecutor<Manager> {
    public Manager findByUsername (String username);
}
