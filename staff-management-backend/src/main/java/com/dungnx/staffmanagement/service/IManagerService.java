package com.dungnx.staffmanagement.service;

import com.dungnx.staffmanagement.entity.Manager;
import com.dungnx.staffmanagement.form.manager.CreateManagerForm;
import com.dungnx.staffmanagement.form.manager.ManagerFilterForm;
import com.dungnx.staffmanagement.form.manager.UpdateManagerForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IManagerService extends UserDetailsService {
    public Page<Manager> getAllManagers(Pageable pageable, String search, ManagerFilterForm filterForm);

    public Manager getManagerById(int id);

    public void createManager(CreateManagerForm form);

    public void updateManager(UpdateManagerForm form);

//	public boolean isManagerExistsByUsername(String username);

    public void deleteManager(Integer id);

    public Manager getManagerByUsername(String username);
}
