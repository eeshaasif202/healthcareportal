package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Admit;
import com.portal.healthcare.model.AdmitDTO;
import com.portal.healthcare.model.Appointment;
import com.portal.healthcare.repository.AdmitRepository;
import com.portal.healthcare.service.AdmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("admit")
public class AdmitController implements CrudController<Admit> {
    @Autowired
    AdmitService admitService;
@Autowired
    AdmitRepository admitRepository;

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return admitService.getById(admitRepository,id);
    }

//    @Override
//    public ResponseEntity<?> getAll() {
//        return admitService.getAll(admitRepository);
//    }
    @GetMapping("/get")
    public ResponseEntity<List<AdmitDTO>> getAllAdmits() {
        List<AdmitDTO> admitDTOs = admitRepository.findAll()
                .stream()
                .map(Admit::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(admitDTOs);
    }

    @Override
    public ResponseEntity<?> save(Admit obj) {
        return admitService.save(admitRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Admit obj) {
        return admitService.update(admitRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return admitService.delete(admitRepository,id);
    }


    @GetMapping("doctor/{doctorId}")
    public ResponseEntity<List<Admit>> getByDoctorId(@PathVariable("doctorId") Integer doctorId, @RequestParam("date") Date date){
        return ResponseEntity.ok(admitService.getAllByDoctorIdAndDate(doctorId,date));
    }












}
