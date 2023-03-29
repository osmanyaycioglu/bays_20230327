package com.training.spring.bays.employee.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.models.Employee;

@RestController
@RequestMapping("/api/v1/employee/query")
public class EmployeeQueryController {

    @GetMapping("/get/one")
    public Employee getOne(@RequestParam("eid") final Long employeeId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<Employee> getAll() {
        return null;
    }

    @GetMapping("/get/by/surname")
    public List<Employee> getBySurname(@RequestParam("surname") final String surname) {
        return null;
    }

}
