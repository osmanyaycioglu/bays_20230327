package com.training.spring.bays.employee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.employee.rest.mappers.IEmployeeMapper;
import com.training.spring.bays.employee.rest.models.Employee;
import com.training.spring.bays.employee.services.EmployeeQueryService;

@RestController
@RequestMapping("/api/v1/employee/query")
public class EmployeeQueryController {

    private final EmployeeQueryService employeeQueryService;

    @Autowired
    public EmployeeQueryController(final EmployeeQueryService employeeQueryServiceParam) {
        super();
        this.employeeQueryService = employeeQueryServiceParam;
    }

    @GetMapping("/get/one")
    public Employee getOne(@RequestParam("eid") final Long employeeId) {
        return IEmployeeMapper.MAPPER.toEmployee(this.employeeQueryService.findEmployee(employeeId));
    }

    @GetMapping("/get/all")
    public List<Employee> getAll() {
        return IEmployeeMapper.MAPPER.toEmployees(this.employeeQueryService.findAllEmployees());
    }

    @GetMapping("/get/by/surname")
    public List<Employee> getBySurname(@RequestParam("surname") final String surname) {
        return IEmployeeMapper.MAPPER.toEmployees(this.employeeQueryService.findAllEmployeesBySurname(surname));
    }

}
