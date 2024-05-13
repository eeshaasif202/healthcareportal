package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Province;
import com.portal.healthcare.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService extends CrudService<Province> {
    @Autowired
    ProvinceRepository provinceRepository;
}
