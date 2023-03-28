package com.training.spring.bays.labs.lab1;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements ICalculator {

    @Override
    public Double add(final Double d1Param,
                      final Double d2Param) {
        return d1Param + d2Param;
    }

    @Override
    public Double subs(final Double d1Param,
                       final Double d2Param) {
        return d1Param - d2Param;
    }

}
