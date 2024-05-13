package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.City;
import com.portal.healthcare.repository.CityRepository;
import com.portal.healthcare.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
public class CityController implements CrudController<City> {
    @Autowired
    CityService cityService;
    @Autowired
    CityRepository cityRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return cityService.getById(cityRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return CityService.getAll(cityRepository);
    }

    @Override
    public ResponseEntity<?> save(City obj) {
        return cityService.save(cityRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(City obj) {
        return cityService.update(cityRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return cityService.delete(cityRepository,id);
    }
}
