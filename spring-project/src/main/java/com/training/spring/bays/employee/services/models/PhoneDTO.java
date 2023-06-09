package com.training.spring.bays.employee.services.models;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "phone")
public class PhoneDTO {

    @Id
    @GeneratedValue
    private Long        phoneId;
    private String      phoneName;
    private String      phoneNumber;

    @JsonIgnore
    @Transient
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private EmployeeDTO employeeDTO;

}
