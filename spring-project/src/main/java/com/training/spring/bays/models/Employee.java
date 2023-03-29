package com.training.spring.bays.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

    private String  firstName;
    private String  lastName;
    private Integer weight;
    private Integer height;
    private Address address;

}
