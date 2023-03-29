package com.training.spring.bays.employee.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.models.Employee;

@RestController
@RequestMapping("/apiv2/v1/employee/provision")
public class EmployeeProvisionController2 {

    @PostMapping
    public String add(@RequestBody final Employee employeeParam) {
        return "OK";
    }

    @DeleteMapping
    public String deactivate(@RequestParam("cid") final Long customerId) {
        return "OK";
    }

    @PatchMapping("/activate")
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
