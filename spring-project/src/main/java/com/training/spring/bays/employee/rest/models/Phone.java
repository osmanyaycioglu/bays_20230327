package com.training.spring.bays.employee.rest.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phone {

    @NotNull
    @NotBlank
    @NotEmpty
    private String phoneName;
    @NotNull
    @NotBlank
    @NotEmpty
    private String phoneNumber;

}
