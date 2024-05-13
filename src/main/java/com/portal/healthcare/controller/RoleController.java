package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Role;
import com.portal.healthcare.repository.RoleRepository;
import com.portal.healthcare.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController implements CrudController<Role> {
    @Autowired
    RoleService roleService;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return roleService.getById(roleRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return roleService.getAll(roleRepository);
    }

    @Override
    public ResponseEntity<?> save(Role obj) {
        return roleService.save(roleRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Role obj) {
        return roleService.update(roleRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return roleService.delete(roleRepository,id);
    }
}
