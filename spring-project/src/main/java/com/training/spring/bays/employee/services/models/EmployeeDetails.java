package com.training.spring.bays.employee.services.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "ed_seq", sequenceName = "ed_seq", allocationSize = 1, initialValue = 1)
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ed_seq")
    private Long   edId;
    private String employeeSecrets;
    private String note;
    private Long   employeeId;
}
