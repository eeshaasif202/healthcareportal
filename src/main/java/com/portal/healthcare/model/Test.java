package com.portal.healthcare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="test")
public class Test {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    //    @ManyToOne
//    @JoinColumn(name="appointment_id")
//    Appointment appointmentId;
    @Column(name="name")
    String name;
    @Column(name="status")
    String status;
    @Column(name = "patient_id")
    int patientId;
    public TestDTO toDTO() {
        TestDTO testDTO = new TestDTO();
        testDTO.setId(this.id);
//        testDTO.setAppointmentId(this.appointmentId != null ? this.appointmentId.getId() : null);
        testDTO.setName(this.name);
        testDTO.setStatus(this.status);
        testDTO.setPatientId(this.patientId);
        return testDTO;
    }

}
