package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Permissions;
import com.portal.healthcare.repository.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionsService extends CrudService<Permissions> {
    @Autowired
    PermissionsRepository permissionsRepository;
}
