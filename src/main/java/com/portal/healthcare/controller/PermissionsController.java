package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Permissions;
import com.portal.healthcare.repository.PermissionsRepository;
import com.portal.healthcare.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Permission;

@RestController
@RequestMapping("permissions")
public class PermissionsController implements CrudController<Permissions> {
    @Autowired
    PermissionsService permissionsService;
    @Autowired
    PermissionsRepository permissionsRepository;

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return permissionsService.getById(permissionsRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return permissionsService.getAll(permissionsRepository);
    }

    @Override
    public ResponseEntity<?> save(Permissions obj) {
        return permissionsService.save(permissionsRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Permissions obj) {
        return permissionsService.update(permissionsRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return permissionsService.delete(permissionsRepository,id);
    }
}
