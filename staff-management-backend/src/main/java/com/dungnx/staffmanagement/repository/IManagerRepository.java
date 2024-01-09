package com.dungnx.salesmanagement.repository;

import com.dungnx.salesmanagement.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IManagerRepository extends JpaRepository<Manager, Integer>, JpaSpecificationExecutor<Manager> {
    public Manager findByUsername (String username);
}
