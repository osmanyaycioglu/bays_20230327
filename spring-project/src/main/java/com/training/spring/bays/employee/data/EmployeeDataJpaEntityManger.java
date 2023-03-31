package com.training.spring.bays.employee.data;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.spring.bays.employee.services.models.EmployeeDTO;
import com.training.spring.bays.employee.services.models.PhoneDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class EmployeeDataJpaEntityManger {

    @PersistenceUnit
    private EntityManagerFactory entityManager;

    @Transactional
    public void insertEmployee(final EmployeeDTO employeeDTOParam) {
        employeeDTOParam.getAddress()
                        .setEmployeeDTO(employeeDTOParam);
        List<PhoneDTO> phonesLoc = employeeDTOParam.getPhones();
        for (PhoneDTO phoneDTOLoc : phonesLoc) {
            phoneDTOLoc.setEmployeeDTO(employeeDTOParam);
        }
        try (EntityManager createEntityManagerLoc = this.entityManager.createEntityManager();) {
            createEntityManagerLoc.joinTransaction();
            createEntityManagerLoc.persist(employeeDTOParam);
            employeeDTOParam.setFirstName("Osman");
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
    }

    public void updateEmployee(final EmployeeDTO employeeDTOParam) {
        try (EntityManager createEntityManagerLoc = this.entityManager.createEntityManager();) {
            boolean containsLoc = createEntityManagerLoc.contains(createEntityManagerLoc);
            if (!containsLoc) {
                createEntityManagerLoc.joinTransaction();
                EmployeeDTO mergeLoc = createEntityManagerLoc.merge(employeeDTOParam);
                mergeLoc.setFirstName("Osman");
            }
            employeeDTOParam.setFirstName("Osman");
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }

    }

    public void deleteEmployee(final Long employeeId) {
    }

    public EmployeeDTO findEmployee(final Long employeeId) {
        try (EntityManager createEntityManagerLoc = this.entityManager.createEntityManager();) {
            TypedQuery<EmployeeDTO> createQueryLoc = createEntityManagerLoc.createQuery("select e from EmployeeDTO e where e.employeeId=?1",
                                                                                        EmployeeDTO.class);
            createQueryLoc.setParameter(1,
                                        employeeId);
            EmployeeDTO singleResultLoc = createQueryLoc.getSingleResult();
            return singleResultLoc;
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

    public List<EmployeeDTO> findAll() {
        try (EntityManager createEntityManagerLoc = this.entityManager.createEntityManager();) {
            TypedQuery<EmployeeDTO> createQueryLoc = createEntityManagerLoc.createQuery("select e from EmployeeDTO e",
                                                                                        EmployeeDTO.class);
            List<EmployeeDTO> resultListLoc = createQueryLoc.getResultList();
            return resultListLoc;
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

    public List<EmployeeDTO> findByLastName(final String lastName) {
        return null;
    }

}
