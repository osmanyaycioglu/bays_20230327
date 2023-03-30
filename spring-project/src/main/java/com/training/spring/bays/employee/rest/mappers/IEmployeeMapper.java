package com.training.spring.bays.employee.rest.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.training.spring.bays.employee.rest.models.Address;
import com.training.spring.bays.employee.rest.models.Employee;
import com.training.spring.bays.employee.rest.models.Phone;
import com.training.spring.bays.employee.services.models.AddressDTO;
import com.training.spring.bays.employee.services.models.EmployeeDTO;
import com.training.spring.bays.employee.services.models.PhoneDTO;

@Mapper
public interface IEmployeeMapper {

    IEmployeeMapper MAPPER = Mappers.getMapper(IEmployeeMapper.class);

    //    @Mapping(source = "weight",target = "details.weight")
    //    @Mapping(source = "height",target = "details.height")
    EmployeeDTO toEmployeeDTO(Employee employee);

    Employee toEmployee(EmployeeDTO employee);

    List<EmployeeDTO> toEmployeeDTOs(List<Employee> employee);

    List<Employee> toEmployees(List<EmployeeDTO> employee);

    AddressDTO toAddressDTO(Address address);

    Address toAddress(AddressDTO address);

    Phone toPhone(PhoneDTO phone);

    PhoneDTO toPhoneDTO(Phone phone);

}
