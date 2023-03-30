package com.training.spring.bays.employee.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.employee.rest.mappers.IEmployeeMapper;
import com.training.spring.bays.employee.rest.models.Employee;
import com.training.spring.bays.employee.services.EmployeeProvisionService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeProvisionController {

    private final EmployeeProvisionService employeeProvisionService;

    @Autowired
    public EmployeeProvisionController(final EmployeeProvisionService employeeProvisionServiceParam) {
        super();
        this.employeeProvisionService = employeeProvisionServiceParam;
    }

    @PostMapping("/add")
    @Operation(description = "long description", summary = "short description", operationId = "add")
    public String add(@Valid @RequestBody final Employee employeeParam) {
        this.employeeProvisionService.addEmployee(IEmployeeMapper.MAPPER.toEmployeeDTO(employeeParam));
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@RequestParam("cid") final Long employeeId) {
        this.employeeProvisionService.deactivate(employeeId);
        return "OK";
    }

    @GetMapping("/activate")
    public String activate(@RequestParam("cid") final Long employeeId) {
        this.employeeProvisionService.activate(employeeId);
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@RequestParam("cid") final Long employeeId) {
        this.employeeProvisionService.suspend(employeeId);
        return "OK";
    }

    @GetMapping("/unsuspend")
    public String unsuspend(@RequestParam("cid") final Long employeeId) {
        this.employeeProvisionService.unsuspend(employeeId);
        return "OK";
    }

}
