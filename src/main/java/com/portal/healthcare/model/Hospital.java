package com.portal.healthcare.model;

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
@Table(name="hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
int id;
    @Column(name = "name")
String name;
    @Column(name="address")
String address;
    @Column(name="phone_no")
String phoneNo;
    @ManyToOne
    @JoinColumn(name="city_id")
City cityId;
    @Column(name="verify")
    String verify;
}
