package com.training.spring.bays.employee.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.training.spring.bays.employee.services.models.EmployeeDTO;

@Service
public class EmployeeProvisionService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeProvisionService.class);

    public void addEmployee(final EmployeeDTO addressDTOParam) {
        EmployeeProvisionService.log.info("Gelen employeeDTO : " + addressDTOParam);
    }

    public void suspend(final Long employeeId) {

    }

    public void unsuspend(final Long employeeIdParam) {
        // TODO Auto-generated method stub

    }

    public void activate(final Long employeeIdParam) {
        // TODO Auto-generated method stub

    }

    public void deactivate(final Long employeeIdParam) {
        // TODO Auto-generated method stub

    }

}
