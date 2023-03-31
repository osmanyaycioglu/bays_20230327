package com.training.spring.bays.employee.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.bays.employee.data.EmployeeData;
import com.training.spring.bays.employee.services.models.EStatus;
import com.training.spring.bays.employee.services.models.EmployeeDTO;

@Service
public class EmployeeProvisionService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeProvisionService.class);

    @Autowired
    private EmployeeData        employeeData;

    public void addEmployee(final EmployeeDTO addressDTOParam) {
        EmployeeProvisionService.log.info("Gelen employeeDTO : " + addressDTOParam);
        this.employeeData.insertEmployee(addressDTOParam);
    }

    public void suspend(final Long employeeId) {
        this.employeeData.updateEmployeeStatus(EStatus.SUSPENDED,
                                               employeeId);
    }

    public void unsuspend(final Long employeeIdParam) {
        this.employeeData.updateEmployeeStatus(EStatus.ACTIVE,
                                               employeeIdParam);

    }

    public void activate(final Long employeeIdParam) {
        this.employeeData.updateEmployeeStatus(EStatus.ACTIVE,
                                               employeeIdParam);
    }

    public void deactivate(final Long employeeIdParam) {
        this.employeeData.updateEmployeeStatus(EStatus.PASSIVE,
                                               employeeIdParam);

    }

}
