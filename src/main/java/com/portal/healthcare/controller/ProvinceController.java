package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Province;
import com.portal.healthcare.repository.ProvinceRepository;
import com.portal.healthcare.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("province")
public class ProvinceController implements CrudController<Province> {
    @Autowired
    ProvinceService provinceService;
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return provinceService.getById(provinceRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return provinceService.getAll(provinceRepository);
    }

    @Override
    public ResponseEntity<?> save(Province obj) {

        return provinceService.save(provinceRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Province obj) {
        return provinceService.update(provinceRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return provinceService.delete(provinceRepository,id);
    }
}
