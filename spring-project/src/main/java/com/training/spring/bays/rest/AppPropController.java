package com.training.spring.bays.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.conf.AppProperties;

@RestController
@RequestMapping("/app")
public class AppPropController {

    @Autowired
    private AppProperties appProperties;

    @GetMapping("/props")
    public AppProperties props() {
        return this.appProperties;
    }

}
