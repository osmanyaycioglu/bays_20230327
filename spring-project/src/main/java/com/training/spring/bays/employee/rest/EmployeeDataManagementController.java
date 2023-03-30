package com.training.spring.bays.employee.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.employee.rest.models.Employee;

@RestController
@RequestMapping("/api/v1/employee/management")
public class EmployeeDataManagementController {

    @PostMapping("/update")
    public String update(@RequestBody final Employee employeeParam) {
        return "OK";
    }

}
