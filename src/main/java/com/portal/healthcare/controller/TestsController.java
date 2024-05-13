package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Admit;
import com.portal.healthcare.model.AdmitDTO;
import com.portal.healthcare.model.Test;
import com.portal.healthcare.model.TestDTO;
import com.portal.healthcare.repository.TestRepository;
import com.portal.healthcare.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("test")
public class TestsController implements CrudController<Test> {
    @Autowired
    TestService testService;
    @Autowired
    TestRepository testRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return testService.getById(testRepository,id);
    }

//    @Override
//    public ResponseEntity<?> getAll() {
//        return testService.getAll(testRepository);
//    }
@GetMapping("/get")
public ResponseEntity<List<TestDTO>> getAllAdmits() {
    List<TestDTO> testDTOS = testRepository.findAll()
            .stream()
            .map(Test::toDTO)
            .collect(Collectors.toList());


    return ResponseEntity.ok(testDTOS);
}
    @GetMapping("/get/{patientId}")
    public ResponseEntity<?> getByPatientId(@PathVariable int patientId){
        return ResponseEntity.ok(testRepository.findByPatientId(patientId));
    }
    @Override
    public ResponseEntity<?> save(Test obj) {
        return testService.save(testRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Test obj) {
        return testService.update(testRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return testService.delete(testRepository,id);
    }
}
