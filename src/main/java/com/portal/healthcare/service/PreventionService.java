package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Prevention;
import com.portal.healthcare.repository.PreventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreventionService extends CrudService<Prevention> {
    @Autowired
    PreventionRepository preventionRepository;
}
