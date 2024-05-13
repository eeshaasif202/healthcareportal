package com.portal.healthcare.model;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String name;

    public UserDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructors, getters, setters...
}
