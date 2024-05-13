package com.portal.healthcare.controller;

import com.portal.healthcare.config.JwtUtil;
import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Symptoms;
import com.portal.healthcare.model.User;
import com.portal.healthcare.repository.SymptomsRepository;
import com.portal.healthcare.repository.UserRepository;
import com.portal.healthcare.service.SymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("symptoms")
public class SymptomsController implements CrudController<Symptoms> {
    @Autowired
    SymptomsService symptomsService;
    @Autowired
    SymptomsRepository symptomsRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return symptomsService.getById(symptomsRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return symptomsService.getAll(symptomsRepository);
    }

    @Override
    public ResponseEntity<?> save(Symptoms obj) {
        return symptomsService.save(symptomsRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Symptoms obj) {
        return symptomsService.update(symptomsRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return symptomsService.delete(symptomsRepository,id);
    }
    @GetMapping("/get/{patientId}")
    public ResponseEntity<List<Symptoms>> getByPatientId(@PathVariable int patientId){
        return ResponseEntity.ok(symptomsRepository.findAllByPatientId(patientId));
    }
    @GetMapping("/get/record")
    public ResponseEntity<List<Symptoms>> getByPatientId(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.extractDoctorIdFromToken(token);
        User user = userRepository.findByUsername(username);
        return ResponseEntity.ok(symptomsRepository.findAllByPatientId(user.getId()));
    }
}
