package com.training.spring.bays.employee.services.models;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeDTO {

    @Id
    @GeneratedValue
    private Long           employeeId;
    @Column(name = "first_name")
    @Size(min = 2, max = 20)
    private String         firstName;
    @Column(name = "last_name", length = 25)
    private String         lastName;
    @Max(400)
    private Integer        weight;
    @Max(300)
    private Integer        height;
    @Enumerated(EnumType.STRING)
    private EStatus        employeeStatus = EStatus.ACTIVE;
    private String         tckno;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employeeDTO")
    private AddressDTO     address;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employeeDTO")
    private List<PhoneDTO> phones;

}
