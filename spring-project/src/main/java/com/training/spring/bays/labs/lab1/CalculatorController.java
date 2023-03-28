package com.training.spring.bays.labs.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final ICalculator calculator;

    @Autowired
    public CalculatorController(final ICalculator calculatorParam) {
        super();
        this.calculator = calculatorParam;
    }

    //http://127.0.0.1:9090/calculator/add/1.2/1.8
    @GetMapping("/add/{abc}/{xyz}")
    public String add(@PathVariable("abc") final Double d1,
                      @PathVariable("xyz") final Double d2) {
        return "Toplama sonucu : "
               + this.calculator.add(d1,
                                     d2);
    }

    // http://127.0.0.1:9090/calculator/subs?d1=3&d2=1.2
    @GetMapping("/subs")
    public String subs(@RequestParam("d1") final Double d1,
                       @RequestParam("d2") final Double d2) {
        return "Çıkarma sonucu : "
               + this.calculator.subs(d1,
                                      d2);
    }

}
