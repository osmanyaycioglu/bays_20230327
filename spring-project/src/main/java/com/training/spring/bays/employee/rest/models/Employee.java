package com.training.spring.bays.employee.rest.models;

import java.util.List;

import com.training.spring.bays.validation.NotContainsStr;

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

    @NotNull(message = "firstName null olmamamlı")
    @NotBlank(message = "sadece space ler den oluşmamalı")
    @NotEmpty
    @Size(min = 2, max = 15)
    @NotContainsStr({
                      "abc",
                      "123",
                      "qwe"
    })
    //@Startwith("fn:")
    private String      firstName;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 20)
    //@Startwith("ln:")
    private String      lastName;
    @NotNull
    @Max(400)
    @Positive
    private Integer     weight;
    @NotNull
    @Max(300)
    @Min(50)
    private Integer     height;
    @NotNull
    @Valid
    private Address     address;

    @NotNull
    @Size(min = 1)
    @Valid
    private List<Phone> phones;
}
