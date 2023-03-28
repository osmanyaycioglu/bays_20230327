package com.training.spring.bays.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.di.hello.IGreetings;

@RestController
@RequestMapping("/greet")
public class GreetingsController {

    private final IGreetings greetings;

    @Autowired
    public GreetingsController(@Qualifier("createDynamicGreet") final IGreetings greetingsParam) {
        super();
        this.greetings = greetingsParam;
    }

    @GetMapping("/say/hello/{first}/{last}")
    public String sayHello(@PathVariable("first") final String firstName,
                           @PathVariable("last") final String lastName) {
        return this.greetings.sayHello(firstName,
                                       lastName);
    }

    @GetMapping("/say/goodbye")
    public String sayGoodbye(@RequestParam("first") final String firstName,
                             @RequestParam("last") final String lastName) {
        return this.greetings.sayGoodBye(firstName,
                                         lastName);
    }

}
