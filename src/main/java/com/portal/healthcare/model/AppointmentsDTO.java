package com.portal.healthcare.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AppointmentsDTO {
    private int id;
    @Nullable
    private int approvedBy;
    private int doctorId;
    private int patientId;
    private String status;
    LocalDate createdAt;
    String startTime;
    String endTime;
    LocalDate appointmentDate;

}
