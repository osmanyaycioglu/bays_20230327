package com.training.spring.bays.employee.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.models.Employee;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee/provision")
public class EmployeeProvisionController {

    @PostMapping("/add")
    @Operation(description = "long description", summary = "short description", operationId = "add")
    public String add(@Valid @RequestBody final Employee employeeParam) {
        return "OK";
    }

    //    @PostMapping("/addx")
    //    public String add(@RequestBody final Employee employeeParam,
    //                      @RequestParam("str") final String str) {
    //        return "OK";
    //    }

    @GetMapping("/deactivate")
    public String deactivate(@RequestParam("cid") final Long customerId) {
        return "OK";
    }

    @GetMapping("/activate")
    public String activate(@RequestParam("cid") final Long customerId) {
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@RequestParam("cid") final Long customerId) {
        return "OK";
    }

    @GetMapping("/unsuspend")
    public String unsuspend(@RequestParam("cid") final Long customerId) {
        return "OK";
    }

}
