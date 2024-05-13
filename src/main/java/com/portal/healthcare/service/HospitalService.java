package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Hospital;
import com.portal.healthcare.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService extends CrudService<Hospital> {
    @Autowired
    HospitalRepository hospitalRepository;

    public List<Hospital> getByCityId(Integer cityId) {
        return hospitalRepository.findByCityId(cityId);
    }
}
