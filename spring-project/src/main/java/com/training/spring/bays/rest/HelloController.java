package com.training.spring.bays.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.bays.di.scope.MyBean;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private MyBean myBean1;

    @Autowired
    private MyBean myBean2;

    @GetMapping("/show/counter1")
    public String showCounter1() {
        return "Counter 1 : " + this.myBean1.method();
    }

    @GetMapping("/show/counter2")
    public String showCounter2() {
        return "Counter 2 : " + this.myBean2.method();
    }

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

    //hello/hello2/osman -> GET http komutuyla request
    @GetMapping("/hello2/{dfg}")
    public String hello2(@PathVariable("dfg") final String name) {
        return "hello GET - 2 - " + name;
    }

    //hello/hello3/osman -> GET http komutuyla request
    @GetMapping("/hello3/{name}")
    public String hello3(@PathVariable final String name) {
        return "hello GET - 3 - " + name;
    }

    //hello/hello4/osman/yaycıoğlu -> GET http komutuyla request
    @GetMapping("/hello4/{dfg}/{cvb}")
    public String hello4(@PathVariable("dfg") final String name,
                         @PathVariable("cvb") final String surname) {
        return "hello GET - 4 - " + name + " " + surname;
    }

    //hello/hello5/osman/soy/yaycıoğlu -> GET http komutuyla request
    @GetMapping("/hello5/{dfg}/soy/{cvb}")
    public String hello5(@PathVariable("dfg") final String name,
                         @PathVariable("cvb") final String surname) {
        return "hello GET - 5 - " + name + " " + surname;
    }

    //hello/hello6/osman/soy/yaycıoğlu -> GET http komutuyla request
    @GetMapping("/hello6/{dfg}/soy/{cvb}/{yas}")
    public String hello6(@PathVariable("dfg") final String name,
                         @PathVariable("cvb") final String surname,
                         @PathVariable("yas") final Integer age) {
        return "hello GET - 6 - " + name + " " + surname + "(" + age + ")";
    }

    //hello/hello6/osman/soy/yaycıoğlu -> GET http komutuyla request
    @GetMapping("/hello7/{dfg}/soy/{cvb}/{yas}/{bd}")
    public String hello7(@PathVariable("dfg") final String name,
                         @PathVariable("cvb") final String surname,
                         @PathVariable("yas") final Integer age,
                         @PathVariable("bd") final LocalDate birthDate) {
        return "hello GET - 7 - " + name + " " + surname + "(" + age + ") " + birthDate;
    }

}
