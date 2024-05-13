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
@Table(name="user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    User userId;
    @Column(name="address")
    String address;
    @Column(name="father_name")
    String fatherName;
    @Column(name="age")
    int age;
    @ManyToOne
    @JoinColumn(name="hospital_id")
    Hospital hospitalId;
    @ManyToOne
    @JoinColumn(name="department_id")
    Department departmentId;


}
