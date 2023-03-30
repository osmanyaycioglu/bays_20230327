package com.training.spring.bays.employee.services.models;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {

    private Long           employeeId;
    private String         firstName;
    private String         lastName;
    private Integer        weight;
    private Integer        height;
    private AddressDTO     address;
    private EStatus        employeeStatus;
    private String         tckno;
    private List<PhoneDTO> phones;

}
