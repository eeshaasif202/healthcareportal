package com.portal.healthcare.controller;

import com.portal.healthcare.config.JwtUtil;
import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Admit;
import com.portal.healthcare.model.AdmitDTO;
import com.portal.healthcare.model.Appointment;
import com.portal.healthcare.model.AppointmentsDTO;
import com.portal.healthcare.repository.AppointmentRepository;
import com.portal.healthcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("appointment")
public class AppointmentController implements CrudController<Appointment> {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return  appointmentService.getById(appointmentRepository,id);
    }

//    @Override
//    public ResponseEntity<?> getAll() {
//        return appointmentService.getAll(appointmentRepository);
//    }
@GetMapping("/get")
public ResponseEntity<List<AppointmentsDTO>> getAll() {
    List<AppointmentsDTO> appointmentsDTOS = appointmentRepository.findAll()
            .stream()
            .map(Appointment::toDTO)
            .collect(Collectors.toList());

    return ResponseEntity.ok(appointmentsDTOS);
}

    @Override
    public ResponseEntity<?> save(Appointment obj) {
        return appointmentService.save(appointmentRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Appointment obj) {
        return appointmentService.update(appointmentRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return appointmentService.delete(appointmentRepository,id);
    }

    @GetMapping("byStatus/{status}")
    public ResponseEntity<List<Appointment>> getByStatus(@PathVariable("status") String status){
        return ResponseEntity.ok(appointmentService.getAllByStatus(status));
    }

     @GetMapping("byDate")
    public ResponseEntity<List<Appointment>> getByDate(@RequestParam("date")Date date){
        return ResponseEntity.ok(appointmentService.getAllByDate(date));
     }

    @GetMapping("/doctor")
    public ResponseEntity<List<AppointmentsDTO>> getByDoctorId(@RequestHeader("Authorization") String token){

        String username = JwtUtil.extractDoctorIdFromToken(token);
        List<AppointmentsDTO> appointmentsDTOS = appointmentService.getAllByDoctorIdAndDate(username)
                .stream()
                .map(Appointment::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentsDTOS);
    }
    @GetMapping("/patient")
    public ResponseEntity<List<AppointmentsDTO>> getByPatientId(@RequestHeader("Authorization") String token){
        String username = JwtUtil.extractDoctorIdFromToken(token);
        List<AppointmentsDTO> appointmentsDTOS = appointmentService.getAllByPatientId(username)
                .stream()
                .map(Appointment::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(appointmentsDTOS);
    }
}
