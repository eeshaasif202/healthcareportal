package com.portal.healthcare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="user")
public class User {
@Setter
@Getter
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
int id;
@Setter
@Getter

@Column(name="username", unique = true)
    @NotNull(message="username cannot be null")
    @NotEmpty(message = "username cannot be empty")
String username;
    @NotNull(message="email cannot be null")
    @NotEmpty(message = "email cannot be empty")
@Setter
@Getter
@Column(name="email", unique = true)
String email;
    @NotNull(message="phone no cannot be null")
    @NotEmpty(message = "phone no cannot be empty")
@Setter
@Getter
@Column(name="phone_no")

String phoneno;
    @NotNull(message="name cannot be null")
    @NotEmpty(message = "name cannot be empty")
@Setter
@Getter
@Column(name="name")
String name;
    @NotNull(message="password cannot be null")
    @NotEmpty(message = "password cannot be empty")
@Setter
@Getter
@Column(name="password")
String password;
@Setter
@Getter
@NotNull(message="gender cannot be null")
@NotEmpty(message = "gender cannot be empty")
@Column(name="gender")
String gender;
@Setter
@Getter
@ManyToOne
@JoinColumn(name="role_id")
Role roleId;
@Setter
@Getter
@Column(name="created_at")
String createdAt;
//    @NotNull(message="This field cannot be null")
//    @NotEmpty(message = "This field cannot be empty")
@Setter
@Getter
@OneToOne(mappedBy = "userId")
@JsonIgnore
UserInfo userInfo;

    @ManyToOne
@JoinColumn(name="hospital_id")
Hospital hospitalId;

    public User() {
    }

    public User(int id, String username, String email, String phoneno, String name,
                String password, String gender, Role roleId, String createdAt, UserInfo userInfo,
                Hospital hospitalId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneno = phoneno;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.roleId = roleId;
        this.createdAt = createdAt;
        this.userInfo = userInfo;
        this.hospitalId = hospitalId;
    }
}
