package com.portal.healthcare.controller;

import com.portal.healthcare.config.JwtUtil;
import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Medicines;
import com.portal.healthcare.model.Observation;
import com.portal.healthcare.model.User;
import com.portal.healthcare.repository.ObservationRepository;
import com.portal.healthcare.repository.UserRepository;
import com.portal.healthcare.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("observation")
public class ObservationController implements CrudController<Observation> {
    @Autowired
    ObservationService observationService;
    @Autowired
    ObservationRepository observationRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return observationService.getById(observationRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return observationService.getAll(observationRepository);
    }

    @Override
    public ResponseEntity<?> save(Observation obj) {
        return observationService.save(observationRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Observation obj) {
        return observationService.update(observationRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return observationService.delete(observationRepository,id);
    }

    @GetMapping("/get/{patientId}")
    public ResponseEntity<?> getByPatientId(@PathVariable int patientId){
        return ResponseEntity.ok(observationRepository.findByPatientId(patientId));
    }
    @GetMapping("/get/record")
    public ResponseEntity<List<Observation>> getByPatientId(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.extractDoctorIdFromToken(token);
        User user = userRepository.findByUsername(username);
        return ResponseEntity.ok(observationRepository.findByPatientId(user.getId()));
    }
}
