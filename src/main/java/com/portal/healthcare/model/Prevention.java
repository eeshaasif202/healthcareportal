package com.portal.healthcare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="prevention")
public class Prevention {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id")
    int id;
//    @ManyToOne
//    @JoinColumn(name="appointment_id")
//    Appointment appointmentId;
    @Column(name="description")
    String description;
    @Column(name="how_often")
    String howOften;
    @Column(name = "patient_id")
    int patientId;
}
