package com.training.spring.bays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

}
