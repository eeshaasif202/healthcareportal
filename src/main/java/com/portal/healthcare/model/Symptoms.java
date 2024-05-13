package com.portal.healthcare.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
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
@Table(name="symptoms")
public class Symptoms {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
//    @ManyToOne
//    @JoinColumn(name="appointment_id")
//    Appointment appointmentId;
    @Column(name="name")
    String name;
    @Column(name="description")
    String description;
    @Column(name="frequency")
    String frequency;
    @Column(name = "patient_id")
    int patientId;
}
