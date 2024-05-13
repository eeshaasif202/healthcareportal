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
@Table(name="admit")
public class Admit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
   @ManyToOne
    @JoinColumn(name="appointment_id")
    Appointment appointmentId;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    User doctorId;
   @ManyToOne
   @JoinColumn(name="room_id")
    Room roomId;
    @Column(name="admit_date")
    LocalDate admitDate;
    @Column(name="discharged_date")
    LocalDate dischargedDate;

    public AdmitDTO toDTO() {
        AdmitDTO admitDTO = new AdmitDTO();
        admitDTO.setId(this.id);
        admitDTO.setAppointmentId(this.appointmentId != null ? this.appointmentId.getId() : null);
        admitDTO.setDoctorId(this.doctorId != null ? this.doctorId.getId() : null);
        admitDTO.setRoomId(this.roomId != null ? this.roomId.getId() : null);
        admitDTO.setAdmitDate(this.admitDate);
        admitDTO.setDischargedDate(this.dischargedDate);
        return admitDTO;
    }
}
