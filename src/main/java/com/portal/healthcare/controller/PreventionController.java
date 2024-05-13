package com.portal.healthcare.controller;

import com.portal.healthcare.config.JwtUtil;
import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Prevention;
import com.portal.healthcare.model.Symptoms;
import com.portal.healthcare.model.User;
import com.portal.healthcare.repository.PreventionRepository;
import com.portal.healthcare.repository.UserRepository;
import com.portal.healthcare.service.PreventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prevention")
public class PreventionController implements CrudController<Prevention> {
    @Autowired
    PreventionService preventionService;
    @Autowired
    PreventionRepository preventionRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return preventionService.getById(preventionRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return preventionService.getAll(preventionRepository);
    }

    @Override
    public ResponseEntity<?> save(Prevention obj) {
        return preventionService.save(preventionRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Prevention obj) {
        return preventionService.update(preventionRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return preventionService.delete(preventionRepository,id);
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<List<Prevention>> getByPatientId(@PathVariable int patientId){
        return ResponseEntity.ok(preventionRepository.findAllByPatientId(patientId));
    }
    @GetMapping("/get/record")
    public ResponseEntity<List<Prevention>> getByPatientId(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.extractDoctorIdFromToken(token);
        User user = userRepository.findByUsername(username);
        return ResponseEntity.ok(preventionRepository.findAllByPatientId(user.getId()));
    }
}
