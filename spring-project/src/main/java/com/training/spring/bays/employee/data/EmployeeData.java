package com.training.spring.bays.employee.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.bays.employee.mongo.IEmployeeMongoDao;
import com.training.spring.bays.employee.services.models.EStatus;
import com.training.spring.bays.employee.services.models.EmployeeDTO;
import com.training.spring.bays.employee.services.models.EmployeeDetails;
import com.training.spring.bays.employee.services.models.EmployeeMongoDTO;
import com.training.spring.bays.employee.services.models.PhoneDTO;

@Service
public class EmployeeData {

    @Autowired
    private IEmployeeDao        employeeDao;

    @Autowired
    private IEmployeeMongoDao   employeeMongoDao;

    @Autowired
    private IEmployeeDetailsDao employeeDetailsDao;

    @Transactional
    public void insertEmployee(final EmployeeDTO employeeDTOParam) {
        employeeDTOParam.getAddress()
                        .setEmployeeDTO(employeeDTOParam);
        List<PhoneDTO> phonesLoc = employeeDTOParam.getPhones();
        for (PhoneDTO phoneDTOLoc : phonesLoc) {
            phoneDTOLoc.setEmployeeDTO(employeeDTOParam);
        }
        this.employeeDao.save(employeeDTOParam);
        EmployeeMongoDTO mongoDTOLoc = new EmployeeMongoDTO();
        mongoDTOLoc.setAddress(employeeDTOParam.getAddress());
        mongoDTOLoc.setPhones(employeeDTOParam.getPhones());
        mongoDTOLoc.setFirstName(employeeDTOParam.getFirstName());
        mongoDTOLoc.setLastName(employeeDTOParam.getLastName());
        this.employeeMongoDao.save(mongoDTOLoc);
        this.insertEmployeeDetails(employeeDTOParam);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertEmployeeDetails(final EmployeeDTO employeeDTOParam) {
        EmployeeDetails detailsLoc = new EmployeeDetails();
        detailsLoc.setEmployeeSecrets("secret1");
        detailsLoc.setNote("Best employee");
        detailsLoc.setEmployeeId(employeeDTOParam.getEmployeeId());
        this.employeeDetailsDao.save(detailsLoc);

    }

    public void updateEmployee(final EmployeeDTO employeeDTOParam) {
        this.employeeDao.save(employeeDTOParam);
    }

    public void deleteEmployee(final Long employeeId) {
        this.employeeDao.deleteById(employeeId);
    }

    public EmployeeDTO findEmployee(final Long employeeId) {
        return this.employeeDao.findById(employeeId)
                               .orElse(null);
    }

    public List<EmployeeDTO> findAll() {
        return this.employeeDao.findAll();
    }

    public List<EmployeeDTO> findByLastName(final String lastName) {
        return this.employeeDao.findByLastName(lastName);
    }

    public void updateEmployeeStatus(final EStatus statusParam,
                                     final Long employeeId) {
        this.employeeDao.updateEmployeeStatus(statusParam,
                                              employeeId);
    }

}
