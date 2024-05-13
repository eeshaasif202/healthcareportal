package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Medicines;
import com.portal.healthcare.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicinesService extends CrudService<Medicines> {
    @Autowired
    MedicinesRepository medicinesRepository;
}
