package com.training.spring.bays.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 15)
    private String  firstName;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 20)
    private String  lastName;
    @NotNull
    @Max(400)
    @Positive
    private Integer weight;
    @NotNull
    @Max(300)
    @Min(50)
    private Integer height;
    @NotNull
    @Valid
    private Address address;

}
