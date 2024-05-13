package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Symptoms;
import com.portal.healthcare.repository.SymptomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomsService extends CrudService<Symptoms> {
    @Autowired
    SymptomsRepository symptomsRepository;
}
