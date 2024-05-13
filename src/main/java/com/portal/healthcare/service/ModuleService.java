package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Module;
import com.portal.healthcare.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService extends CrudService<Module> {
    @Autowired
    ModuleRepository moduleRepository;
}
