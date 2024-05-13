package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Appointment;
import com.portal.healthcare.model.User;
import com.portal.healthcare.repository.AppointmentRepository;
import com.portal.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService extends CrudService<Appointment>{
    @Autowired
    AppointmentRepository appointmentRepository ;
    @Autowired
    UserRepository userRepository;

    public List<Appointment> getAllByStatus(String status) {
        return appointmentRepository.findAllByStatus(status);
    }

    public List<Appointment> getAllByDate(Date date) {
        return appointmentRepository.findAllByStartTime(date);
    }

    public List<Appointment> getAllByDoctorIdAndDate(String username) {

        User user = userRepository.findByUsername(username);
        int userId = user.getId();
        return appointmentRepository.findAllByDoctorId(userId);
    }

    public List<Appointment> getAllByPatientId(String username) {
        User user = userRepository.findByUsername(username);
        int patientId = user.getId();
        return appointmentRepository.findAllByPatientId(patientId);
    }
}
