package com.portal.healthcare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="appointment")
public class Appointment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    User doctorId;
    @ManyToOne
    @JoinColumn(name="patient_id")
    User patientId;
    @ManyToOne
    @JoinColumn(name="approved_by")
    User approvedBy;
    @Column(name="created_at")
    LocalDate createdAt;
    @Column(name="status")
    String status;
    @Column(name="start_time")
    String startTime;
    @Column(name="end_time")
    String endTime;
    @Column(name="appointment_date")
    LocalDate appointmentDate;

    public AppointmentsDTO toDTO() {
        AppointmentsDTO appointmentsDTO = new AppointmentsDTO();
        appointmentsDTO.setId(this.id);
        appointmentsDTO.setApprovedBy(this.approvedBy != null ? this.approvedBy.getId() : 0);
        appointmentsDTO.setDoctorId(this.doctorId != null ? this.doctorId.getId() : null);
        appointmentsDTO.setPatientId(this.patientId != null ? this.patientId.getId() : null);
        appointmentsDTO.setStatus(this.status);
        appointmentsDTO.setCreatedAt(this.createdAt);
        appointmentsDTO.setStartTime(this.startTime);
        appointmentsDTO.setEndTime(this.endTime);
        appointmentsDTO.setAppointmentDate(this.appointmentDate);
        return appointmentsDTO;
    }

}
