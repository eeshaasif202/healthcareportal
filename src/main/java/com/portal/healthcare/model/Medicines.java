package com.portal.healthcare.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="medicines")
public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="description")
    String description;
    @Column(name="instructions_for_use")
    String instructionsForUse;
    @Column(name = "patient_id")
    int patientId;
//    @ManyToOne
//    @JoinColumn(name="appointment_id")
//    Appointment appointmentId;
}
