package com.training.spring.bays.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    //hello/hello1 -> GET http komutuyla request
    // @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    @GetMapping("/hello1")
    public String hello1() {
        return "hello GET - 1";
    }

    //hello/hello1 -> POST http komutuyla request
    @PostMapping("/hello1")
    public String xyz() {
        return "hello POST - 1";
    }

    //hello/hello1 -> PUT http komutuyla request
    @PutMapping("/hello1")
    public String aabc() {
        return "hello PUT - 1";
    }

}
