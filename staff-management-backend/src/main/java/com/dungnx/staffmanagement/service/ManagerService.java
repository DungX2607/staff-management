package com.dungnx.salesmanagement.service;

import com.dungnx.salesmanagement.entity.Manager;
import com.dungnx.salesmanagement.form.manager.CreateManagerForm;
import com.dungnx.salesmanagement.form.manager.ManagerFilterForm;
import com.dungnx.salesmanagement.form.manager.UpdateManagerForm;
import com.dungnx.salesmanagement.repository.IManagerRepository;
import com.dungnx.salesmanagement.specification.Manager.ManagerSpecification;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ManagerService implements IManagerService{
    @Autowired
    private IManagerRepository managerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<Manager> getAllManagers(
            Pageable pageable,
            String search,
            ManagerFilterForm filterForm) {

        Specification<Manager> where = ManagerSpecification.buildWhere(search, filterForm);
        return managerRepository.findAll(where, pageable);
    }

    public Manager getManagerById(int id) {
        return managerRepository.findById(id).get();
    }

    @Transactional
    public void createManager(CreateManagerForm form) {

        // bỏ qua trường ID
        TypeMap<CreateManagerForm, Manager> typeMap = modelMapper.getTypeMap(CreateManagerForm.class, Manager.class);
        if (typeMap == null) { // nếu chưa được thêm
            // bỏ qua trường
            modelMapper.addMappings(new PropertyMap<CreateManagerForm, Manager>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }

        // chuyển đổi form thành entity
        Manager manager = modelMapper.map(form, Manager.class);

        managerRepository.save(manager);

    }

    public void updateManager(UpdateManagerForm form) {

        // chuyển đổi form thành entity
        Manager manager = modelMapper.map(form, Manager.class);

        managerRepository.save(manager);
    }

//	public boolean isManagerExistsByUsername(String username) {
//		return managerRepository.existsByUsername(username);
//	}

    @Transactional
    public void deleteManager(Integer id) {
        Manager manager = getManagerById(id);

        managerRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByUsername(username);

        if(manager == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(manager.getUsername(), manager.getPassword(), AuthorityUtils.createAuthorityList(manager.getRole().toString()));
    }

    public Manager getManagerByUsername(String username) {
        return managerRepository.findByUsername(username);
    }
}
