package com.portal.healthcare.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="observation")

public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
//    @ManyToOne
////    @JoinColumn(name="appointment_id")
//    Appointment appointmentId;
    @Column(name="description")
    String description;
    @Column(name = "patient_id")
    int patientId;





}
