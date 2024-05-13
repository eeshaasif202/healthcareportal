package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Module;
import com.portal.healthcare.repository.ModuleRepository;
import com.portal.healthcare.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("module")
public class ModuleController implements CrudController<Module> {
    @Autowired
    ModuleService moduleService;
    @Autowired
    ModuleRepository moduleRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return moduleService.getById(moduleRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return moduleService.getAll(moduleRepository);
    }

    @Override
    public ResponseEntity<?> save(Module obj) {
        return moduleService.save(moduleRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Module obj) {
        return moduleService.update(moduleRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return moduleService.delete(moduleRepository,id);
    }
}
