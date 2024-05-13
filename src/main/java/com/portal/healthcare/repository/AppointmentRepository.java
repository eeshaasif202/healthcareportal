package com.portal.healthcare.repository;

import com.portal.healthcare.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    List<Appointment>findAllByStatus(String status);
    @Query("SELECT e FROM Appointment e " +
            "WHERE FUNCTION('CONVERT', java.util.Date, e.startTime) = :date")
    List<Appointment> findAllByStartTime(Date date);
    @Query("SELECT e FROM Appointment e WHERE e.doctorId.id = :doctorId")
    List<Appointment> findAllByDoctorId(@Param("doctorId") int doctorId);
     @Query("select a from Appointment a where a.patientId.id=:patientId")
    List<Appointment> findAllByPatientId(@Param("patientId") int patientId);
}
