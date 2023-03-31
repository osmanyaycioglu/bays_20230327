package com.training.spring.bays.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.bays.employee.data.EmployeeData;
import com.training.spring.bays.employee.services.models.EmployeeDTO;

@Service
public class EmployeeQueryService {

    @Autowired
    private EmployeeData employeeData;

    public EmployeeDTO findEmployee(final Long employeeIdParam) {
        return this.employeeData.findEmployee(employeeIdParam);
    }

    public List<EmployeeDTO> findAllEmployees() {
        return this.employeeData.findAll();
    }

    public List<EmployeeDTO> findAllEmployeesBySurname(final String surnameParam) {
        return this.employeeData.findByLastName(surnameParam);
    }

}
