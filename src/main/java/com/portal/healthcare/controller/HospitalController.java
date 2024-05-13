package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.City;
import com.portal.healthcare.model.Hospital;
import com.portal.healthcare.repository.HospitalRepository;
import com.portal.healthcare.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hospital")
public class HospitalController implements CrudController<Hospital> {
    @Autowired
    HospitalService hospitalService;
    @Autowired
    HospitalRepository hospitalRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return hospitalService.getById(hospitalRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return hospitalService.getAll(hospitalRepository);
    }

    @Override
    public ResponseEntity<?> save(Hospital obj) {
        return hospitalService.save(hospitalRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Hospital obj) {
        return hospitalService.update(hospitalRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return hospitalService.delete(hospitalRepository,id);
    }
    @GetMapping("byCity/{id}")
    public ResponseEntity<List<Hospital>> getByCityId(@PathVariable("id")Integer cityId){
        return ResponseEntity.ok(hospitalService.getByCityId(cityId));
    }
}
