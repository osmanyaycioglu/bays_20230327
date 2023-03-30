package com.training.spring.bays.employee.rest.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

    @NotNull
    @NotEmpty
    private String city;
    @NotNull
    @NotEmpty
    private String street;

}
