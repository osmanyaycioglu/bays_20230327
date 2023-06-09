package com.training.spring.bays.di.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Primary
@Component("tr-greet")
@Qualifier("greetings-tr")
public class GreetingsImpl implements IGreetings {

    @Override
    public String sayHello(final String nameParam,
                           final String surnameParam) {
        return "Selam " + nameParam + " " + surnameParam;
    }

    @Override
    public String sayGoodBye(final String nameParam,
                             final String surnameParam) {
        return "Güle güle " + nameParam + " " + surnameParam;
    }

}
