package com.training.spring.bays.employee.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.training.spring.bays.employee.services.models.EStatus;
import com.training.spring.bays.employee.services.models.EmployeeDTO;

import jakarta.transaction.Transactional;

public interface IEmployeeDao extends JpaRepository<EmployeeDTO, Long> {

    List<EmployeeDTO> findByLastName(String lastName);

    List<EmployeeDTO> findByLastNameAndFirstName(String lastName,
                                                 String firstName);

    List<EmployeeDTO> findByLastNameAndFirstNameOrderByFirstNameDesc(String lastName,
                                                                     String firstName);

    List<EmployeeDTO> findByLastNameLike(String lastLike);

    @Query("select e from EmployeeDTO e where e.lastName=?1")
    List<EmployeeDTO> searchLastName(String lastName);

    @Query("select e from EmployeeDTO e where e.lastName=?1 and e.firstName=?2")
    List<EmployeeDTO> searchLastNameAndFirstName(String lastName,
                                                 String firstName);

    @Query(value = "select * from employee e where e.last_name=?1", nativeQuery = true)
    List<EmployeeDTO> searchLastNameNative(String lastName);

    @Transactional
    @Modifying
    @Query("update EmployeeDTO e set e.employeeStatus=?1 where e.employeeId=?2")
    void updateEmployeeStatus(EStatus status,
                              Long employeeId);

}
