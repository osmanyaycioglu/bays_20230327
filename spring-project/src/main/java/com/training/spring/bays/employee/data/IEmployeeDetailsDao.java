package com.training.spring.bays.employee.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.bays.employee.services.models.EmployeeDetails;

public interface IEmployeeDetailsDao extends JpaRepository<EmployeeDetails, Long> {

}
