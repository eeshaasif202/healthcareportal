package com.portal.healthcare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @ManyToOne
    @JoinColumn(name="role_id")
    Role roleId;
    @ManyToOne
    @JoinColumn(name="module_id")
    Module moduleId;
    @Column(name="create")
    int create;
    @Column(name="delete")
    int delete;
    @Column(name="update")
    int update;
    @Column(name="read")
    int read;

}
