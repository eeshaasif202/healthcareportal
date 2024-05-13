package com.portal.healthcare.controller;

import com.portal.healthcare.config.JwtUtil;
import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.AppointmentsDTO;
import com.portal.healthcare.model.Medicines;
import com.portal.healthcare.model.User;
import com.portal.healthcare.repository.MedicinesRepository;
import com.portal.healthcare.repository.UserRepository;
import com.portal.healthcare.service.MedicinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicines")
public class MedicinesController implements CrudController<Medicines> {
    @Autowired
    MedicinesService medicinesService;
    @Autowired
    MedicinesRepository medicinesRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return medicinesService.getById(medicinesRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return medicinesService.getAll(medicinesRepository);
    }

    @Override
    public ResponseEntity<?> save(Medicines obj) {
        return medicinesService.save(medicinesRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Medicines obj) {
        return medicinesService.update(medicinesRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return medicinesService.delete(medicinesRepository,id);
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<List<Medicines>> getByPatientId(@PathVariable int patientId){
        return ResponseEntity.ok(medicinesRepository.findAllByPatientId(patientId));
    }
    @GetMapping("/get/record")
    public ResponseEntity<List<Medicines>> getByPatientId(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.extractDoctorIdFromToken(token);
        User user = userRepository.findByUsername(username);
        return ResponseEntity.ok(medicinesRepository.findAllByPatientId(user.getId()));
    }
}
