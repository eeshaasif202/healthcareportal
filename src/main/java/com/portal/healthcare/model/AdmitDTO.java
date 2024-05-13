package com.portal.healthcare.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdmitDTO {
    private int id;
    private int appointmentId;
    private int doctorId;
    private int roomId;
    private LocalDate admitDate;
    private LocalDate dischargedDate;
}
