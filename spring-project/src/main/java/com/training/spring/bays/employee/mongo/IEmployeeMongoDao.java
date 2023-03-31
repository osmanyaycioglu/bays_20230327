package com.training.spring.bays.employee.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.training.spring.bays.employee.services.models.EmployeeMongoDTO;

public interface IEmployeeMongoDao extends MongoRepository<EmployeeMongoDTO, String> {

}
