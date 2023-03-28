package com.training.spring.bays.di.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyBean {

    private int counter;

    public int method() {
        this.counter++;
        System.out.println("Counter : " + this.counter);
        return this.counter;
    }

}
