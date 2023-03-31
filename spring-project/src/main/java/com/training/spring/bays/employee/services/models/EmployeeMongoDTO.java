package com.training.spring.bays.employee.services.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document
public class EmployeeMongoDTO extends EmployeeDTO {

    @Id
    private String id;

}
