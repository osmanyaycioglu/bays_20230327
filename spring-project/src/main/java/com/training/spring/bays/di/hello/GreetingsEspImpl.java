package com.training.spring.bays.di.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("esp-greet")
@Qualifier("greetings-esp")
public class GreetingsEspImpl implements IGreetings {

    @Override
    public String sayHello(final String nameParam,
                           final String surnameParam) {
        return "Ola " + nameParam + " " + surnameParam;
    }

    @Override
    public String sayGoodBye(final String nameParam,
                             final String surnameParam) {
        return "Adios " + nameParam + " " + surnameParam;
    }

}
